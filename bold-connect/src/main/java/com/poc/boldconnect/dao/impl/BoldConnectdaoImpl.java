package com.poc.boldconnect.dao.impl;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.internal.IteratorSupport;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.poc.boldconnect.dao.BoldConnectDao;
import com.poc.boldconnect.model.domain.Account;
import com.poc.boldconnect.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class BoldConnectdaoImpl implements BoldConnectDao {

    private static Logger LOG = LoggerFactory.getLogger(BoldConnectdaoImpl.class);

    @Autowired
    private DynamoDB dynamoDB;

    @Override
    public void saveAccounts(List<Account> accounts) {

      LOG.info(" Save Accounts started");

        Table table =  dynamoDB.getTable("Accounts");
        for (Account account:accounts)
            {
            Item item= new Item()
                    .withPrimaryKey("accountId",account.getAccountId())
                    .with("userAccountId",String.valueOf(account.getUserAccountId()))
                    .withString("externalAccountRefId",account.getExternalAccountRefId())
                    .withString("accountType",account.getAccountType())
                    .withString("accountStatus",account.getAccountStatus())
                    .withString("financialInstituteCode",account.getFinancialInstituteCode())
                    .withString("financialInstName",account.getFinancialInstName())
                    .withString("displayAccountNumber",account.getDisplayAccountNumber())
                    .withString("createdDate", LocalDateTime.now().toString())
                    .withString("modifiedDate",LocalDateTime.now().toString())
                    .withString("currencyCode","USD")
                    .withString("dataProviderCode",account.getDataProviderCode())
                    .withNumber("availableBalance",account.getAvailableBalance())
                    .withNumber("currentBalance",account.getCurrentBalance());

            PutItemOutcome outcome = table.putItem(item);
            LOG.info("Data saved in dynamoDb outcome     {}",outcome);

        }

        LOG.info(" Save Accounts end");

    }

    @Override
    public List<Account> getAccounts(String userAccountId) {

        Table table = dynamoDB.getTable("Accounts");
        QuerySpec spec = new QuerySpec()
                        .withKeyConditionExpression("userAccountId = :v_userAcctId and accountStatus =:v_accountStatus")
                        .withValueMap(new ValueMap()
                                .withString(":v_userAcctId",userAccountId)
                                .withString(":v_accountStatus","ACTIVE"))
                        .withConsistentRead(true);

        List<Account> accounts = new ArrayList<>();

        ItemCollection<QueryOutcome> items = table.query(spec);
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
           LOG.info("Data fetched from dynamodb -----> {} ",iterator.next().toJSONPretty());
           Account account = CommonUtils.convertJSONToObject(iterator.next().toJSON(), Account.class);
           accounts.add(account);
        }

        return accounts;
    }
}
