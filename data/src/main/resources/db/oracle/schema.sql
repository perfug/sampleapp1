drop table CategoryFamily_VAT;
drop table VAT;
drop table SaleOperation;
drop table SaleTransaction;
drop table Stock;
drop table Product;
drop table CategoryFamily;
drop table Store;
drop table Country;
drop sequence hibernate_sequence;

create table CategoryFamily (id number(19,0) not null, commissionRate number(19,2), deletionDate timestamp, familyPressType number(10,0), familyType varchar2(255 char), groupid number(10,0), isDeletable number(1,0), isDiscountable number(1,0), isTracked number(1,0), label varchar2(255 char), margin number(19,0), marginCoefficient number(19,2), marginType number(10,0), maximumAuthorisedAmount number(19,0), minimumAuthorisedAmount number(19,0), modificationDate timestamp, productType number(10,0), primary key (id));
create table CategoryFamily_VAT (CategoryFamily_id number(19,0) not null, vats_id number(19,0) not null, primary key (CategoryFamily_id, vats_id));
create table Country (alpha3Code varchar2(255 char) not null, countryName varchar2(255 char), numericCode number(10,0), primary key (alpha3Code));
create table Product (id number(19,0) not null, buyPrice number(19,0), canPutBack number(1,0), commission number(19,2), deletionDate timestamp, deliveredQuantity number(10,0), eanCode varchar2(255 char), groupId number(10,0), isActive number(1,0), isFollowInStock number(1,0), isGenericProdct number(1,0), isOnlineProduct number(1,0), isProductionMonitoringManual number(1,0), isReference number(1,0), isSellable number(1,0), manualMargin number(1,0), manualMarginType number(1,0), manualVat number(1,0), margin number(19,0), marginCoefficient number(19,2), modificationDate timestamp, previousBuyPrice number(19,0), productLabel varchar2(255 char), productMarginType number(10,0), productType number(10,0), ranking number(10,0), sellPrice number(19,2), updatablePrice number(1,0), categoryFamily_id number(19,0), parentProduct_id number(19,0), primary key (id));
create table SaleOperation (id number(19,0) not null, amount number(19,2), annulation timestamp, annulationCashierName varchar2(255 char), annulationCashierNumber number(10,0), annulationType number(10,0), bossTransactionNumber varchar2(255 char), businessCategory number(10,0), cashierName varchar2(255 char), cashierNumber number(10,0), currency varchar2(255 char), OPERATIONDATE timestamp, discountAmount varchar2(255 char), discountRate number(19,0), groupId number(10,0), increaseRate number(19,0), isBackToStock number(1,0), isReturn number(1,0), isScanned number(1,0), onlineSaleStatus varchar2(255 char), productLabel varchar2(255 char), quantity number(10,0), reloadCode varchar2(255 char), salesCode varchar2(255 char), specialOperationTypeSalePrice number(10,0), supplierProductReference varchar2(255 char), product_id number(19,0), saleTransaction_id number(19,0), primary key (id));
create table SaleTransaction (id number(19,0) not null, cancellation timestamp, cancellationClerkName varchar2(255 char), cancellationClerkNumber number(10,0), cancellationTicketNumber number(10,0), cancellationType number(10,0), changeAmount varchar2(255 char), clerkName varchar2(255 char), clerkNumber number(10,0), clientName varchar2(255 char), clientNumber number(10,0), discountAmount varchar2(255 char), discountRate number(19,0), groupId number(10,0), startDate timestamp, ticketNumber number(10,0), totalAmount number(19,2), transactionKey varchar2(255 char), primary key (id));
create table Stock (id number(19,0) not null, groupId number(10,0), isKeptAfterCallback number(1,0), modificationDate timestamp, quantity number(10,0), stockType number(10,0), product_id number(19,0), store_id number(19,0), primary key (id));
create table Store (id number(19,0) not null, apeCode varchar2(255 char), contactReference varchar2(255 char), dealerParametersReference varchar2(255 char), distributorParametersReference varchar2(255 char), generalParametersReference varchar2(255 char), groupId number(10,0), legalForm varchar2(255 char), mailServerReference varchar2(255 char), managementCenter1Reference varchar2(255 char), managementCenter2Reference varchar2(255 char), managementCenterSuscriber varchar2(255 char), nVAT varchar2(255 char), rcs varchar2(255 char), storeName varchar2(255 char), storeReference varchar2(255 char), primary key (id));
create table VAT (id number(19,0) not null, deletionDate timestamp, groupId number(10,0), isDeletable number(1,0), isExempted number(1,0), vatLabel varchar2(255 char), vatRate number(20,10), vatType number(10,0), country_alpha3Code varchar2(255 char), primary key (id));
alter table CategoryFamily_VAT add constraint FK6AE7336C7CD9FBB0 foreign key (CategoryFamily_id) references CategoryFamily;
alter table CategoryFamily_VAT add constraint FK6AE7336CE300D6E3 foreign key (vats_id) references VAT;
alter table Product add constraint FK50C664CF835F3F2E foreign key (parentProduct_id) references Product;
alter table Product add constraint FK50C664CF7CD9FBB0 foreign key (categoryFamily_id) references CategoryFamily;
alter table SaleOperation add constraint FK4ACCC4C04589BBE4 foreign key (saleTransaction_id) references SaleTransaction;
alter table SaleOperation add constraint FK4ACCC4C052FF8304 foreign key (product_id) references Product;
alter table Stock add constraint FK4C806F6AA01878D foreign key (store_id) references Store;
alter table Stock add constraint FK4C806F652FF8304 foreign key (product_id) references Product;
alter table VAT add constraint FK14B09FFF9D8B foreign key (country_alpha3Code) references Country;
alter table SaleOperation ADD INDEX GRPID_DATE_INDEX (groupId ASC, OPERATIONDATE ASC); 
create sequence hibernate_sequence;

purge recyclebin;