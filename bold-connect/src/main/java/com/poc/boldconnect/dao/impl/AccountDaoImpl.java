package com.poc.boldconnect.dao.impl;

import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.poc.boldconnect.dao.AccountDao;
import com.poc.boldconnect.model.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static com.poc.boldconnect.util.CommonUtils.convertJSONToObject;
import static com.poc.boldconnect.util.CommonUtils.formatDateTime;

@Repository
public class AccountDaoImpl implements AccountDao {

    public static final String ACCT = "acct#";
    private static Logger LOG = LoggerFactory.getLogger(AccountDaoImpl.class);

    @Autowired
    private DynamoDB dynamoDB;

    @Override
    public void saveAccounts(List<Account> accounts) {

        LOG.info(" Save Accounts started");

        Table table = dynamoDB.getTable("Accounts");
        for (Account account : accounts) {
            Item item = new Item()
                    .withPrimaryKey("userAccountId", account.getUserAccountId())
                    .with("accountId", ACCT +UUID.randomUUID().toString())
                    .withString("externalAccountRefId", account.getExternalAccountRefId())
                    .withString("accountType", account.getAccountType())
                    .withString("accountStatus", account.getAccountStatus())
                    .withString("financialInstituteCode", account.getFinancialInstituteCode())
                    .withString("financialInstName", account.getFinancialInstName())
                    .withString("displayAccountNumber", account.getDisplayAccountNumber())
                    .withString("createdDate", formatDateTime(LocalDateTime.now()))
                    .withString("modifiedDate", formatDateTime(LocalDateTime.now()))
                    .withString("currencyCode", account.getCurrencyCode())
                    .withString("dataProviderCode", account.getDataProviderCode())
                    .withNumber("availableBalance", account.getAvailableBalance())
                    .withNumber("currentBalance", account.getCurrentBalance());


//            PutItemOutcome outcome = table.putItem(item);

            PutItemSpec putItemSpec = new PutItemSpec()
                    .withItem(item);

            PutItemOutcome putItemOutcome = table.putItem(putItemSpec);

            LOG.info("Data saved in dynamoDb outcome     {}", putItemOutcome);

        }

        LOG.info(" Save Accounts end");

    }

    @Override
    public void updateAccounts(List<Account> accounts) {

        String uuid = UUID.randomUUID().toString();

        Table table = dynamoDB.getTable("Accounts");

//        for(DemographicAccount account: accounts){
//
//            UpdateItemSpec updateItemSpec = new UpdateItemSpec()
//                                            .withPrimaryKey("userAccountId",account.getUserAccountId())
//                                            .withUpdateExpression("set ")
//                                            .withConditionExpression("accountId")
//        }
    }

    @Override
    public List<Account> getAccounts(String userAccountId) {

        Table table = dynamoDB.getTable("Accounts");
        QuerySpec spec = new QuerySpec()
                .withKeyConditionExpression("userAccountId = :v_userAcctId and begins_with(accountId, :v_acctId)")
                .withValueMap(new ValueMap()
                        .withString(":v_userAcctId", userAccountId)
                        .withString(":v_acctId",ACCT))
                .withConsistentRead(true);

        List<Account> accounts = new ArrayList<>();

        ItemCollection<QueryOutcome> items = table.query(spec);

        String data = null;
        Iterator<Item> iterator = items.iterator();

        while (iterator.hasNext()) {
            data = iterator.next().toJSON();
            LOG.info("Data fetched from dynamodb -----> {} ", data);
            Account account = convertJSONToObject(data, Account.class);
            LOG.info("account converted {}", account);
            accounts.add(account);
            data = null;
        }

        LOG.info("size of accounts -----> {}", accounts != null ? accounts.size() : 0);
        return accounts;
    }
}
