package com.poc.boldconnect.dao.impl;

import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.poc.boldconnect.dao.TransactionDao;
import com.poc.boldconnect.model.domain.Transaction;
import com.poc.boldconnect.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static com.poc.boldconnect.util.CommonUtils.formatDateTime;

@Repository
public class TransactionDaoImpl implements TransactionDao {

    public static final String TRAN = "tran#";
    private static Logger LOG = LoggerFactory.getLogger(TransactionDaoImpl.class);

    @Autowired
    private DynamoDB dynamoDB;

    @Override
    public void saveTransactions(List<Transaction> transactions) {

        LOG.info(" saveTransactions started");

        Table table =  dynamoDB.getTable("Transactions");
        for (Transaction transaction:transactions)
        {
            Item item= new Item()
                    .withPrimaryKey("userAccountId",String.valueOf(transaction.getUserAccountId()))
                    .withString("transactionId", TRAN+UUID.randomUUID().toString())
                   .withString("accountId",transaction.getAccountId())
                    .withString("accountCategoryType",transaction.getAccountCategoryType())
                    .withNumber("transactionAmount",transaction.getTransactionAmount())
                    .withString("transactionDate",String.valueOf(transaction.getTransactionDate()))
                    .withString("transactionType",transaction.getTransactionType())
                    .withString("transactionMemoDesc",transaction.getTransactionMemoDesc())
                    .withString("transactionPostingDate",String.valueOf(transaction.getTransactionPostingDate()))
                    .withString("transactionStatus",transaction.getTransactionStatus())
                    .withString("externalTransactionRefId",transaction.getExternalTransactionRefId())
                    .withString("externalAccountRefId",transaction.getExternalAccountRefId())
                    .withString("transactionCurrencyCode",transaction.getTransactionCurrencyCode())
                    .withString("dataProviderCode",transaction.getDataProviderCode())
                    .withString("createdDate", formatDateTime(LocalDateTime.now()))
                    .withString("modifiedDate",formatDateTime(LocalDateTime.now()));

            PutItemOutcome outcome = table.putItem(item);
            LOG.info("Data saved in dynamoDb outcome     {}",outcome);

        }

        LOG.info(" saveTransactions end");
    }

    @Override
    public List<Transaction> getTransactions(String userAccountId) {

        Table table = dynamoDB.getTable("Transactions");
        QuerySpec spec = new QuerySpec()
                .withKeyConditionExpression("userAccountId = :v_userAcctId and begins_with(transactionId, :v_transactionId)")
                .withValueMap(new ValueMap()
                        .withString(":v_userAcctId",userAccountId)
                        .withString(":v_transactionId", TRAN))
                .withConsistentRead(true);

        List<Transaction> txns = new ArrayList<>();
        String data =null;
        ItemCollection<QueryOutcome> items = table.query(spec);

       Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            data = iterator.next().toJSONPretty();
            LOG.info("Data fetched from dynamodb -----> {} ",data);
            Transaction transaction = CommonUtils.convertJSONToObject(data, Transaction.class);
            LOG.info("transaction converted {}", transaction);
            txns.add(transaction);
            data=null;
        }

        LOG.info("size of transactions -----> {}",txns!=null?txns.size():0);
        return txns;
    }
}
