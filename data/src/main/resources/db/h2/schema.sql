drop table CategoryFamily_VAT;
drop table VAT;
drop table SaleOperation;
drop table SaleTransaction;
drop table Stock;
drop table Product;
drop table CategoryFamily;
drop table Store;
drop table Country;

create table CategoryFamily (id bigint generated by default as identity, commissionRate numeric, deletionDate timestamp, familyPressType integer, familyType varchar(255), groupid integer, isDeletable bit, isDiscountable bit, isTracked bit, label varchar(255), margin bigint, marginCoefficient numeric, marginType integer, maximumAuthorisedAmount bigint, minimumAuthorisedAmount bigint, modificationDate timestamp, productType integer, primary key (id));
create table CategoryFamily_VAT (CategoryFamily_id bigint not null, vats_id bigint not null, primary key (CategoryFamily_id, vats_id));
create table Country (alpha3Code varchar(255) not null, countryName varchar(255), numericCode integer, primary key (alpha3Code));
create table Product (id bigint generated by default as identity, buyPrice bigint, canPutBack bit, commission numeric, deletionDate timestamp, deliveredQuantity integer, eanCode varchar(255), groupId integer, isActive bit, isFollowInStock bit, isGenericProdct bit, isOnlineProduct bit, isProductionMonitoringManual bit, isReference bit, isSellable bit, manualMargin bit, manualMarginType bit, manualVat bit, margin bigint, marginCoefficient numeric, modificationDate timestamp, previousBuyPrice bigint, productLabel varchar(255), productMarginType integer, productType integer, ranking integer, sellPrice numeric, updatablePrice bit, categoryFamily_id bigint, parentProduct_id bigint, primary key (id));
create table SaleOperation (id bigint generated by default as identity, amount numeric, annulation timestamp, annulationCashierName varchar(255), annulationCashierNumber integer, annulationType integer, bossTransactionNumber varchar(255), businessCategory integer, cashierName varchar(255), cashierNumber integer, currency varchar(255), OPERATIONDATE timestamp, discountAmount varchar(255), discountRate bigint, groupId integer, increaseRate bigint, isBackToStock bit, isReturn bit, isScanned bit, onlineSaleStatus varchar(255), productLabel varchar(255), quantity integer, reloadCode varchar(255), salesCode varchar(255), specialOperationTypeSalePrice integer, supplierProductReference varchar(255), product_id bigint, saleTransaction_id bigint, primary key (id));
create table SaleTransaction (id bigint generated by default as identity, cancellation timestamp, cancellationClerkName varchar(255), cancellationClerkNumber integer, cancellationTicketNumber integer, cancellationType integer, changeAmount varchar(255), clerkName varchar(255), clerkNumber integer, clientName varchar(255), clientNumber integer, discountAmount varchar(255), discountRate bigint, groupId integer, startDate timestamp, ticketNumber integer, totalAmount numeric, transactionKey varchar(255), primary key (id));
create table Stock (id bigint generated by default as identity, groupId integer, isKeptAfterCallback bit, modificationDate timestamp, quantity integer, stockType integer, product_id bigint, store_id bigint, primary key (id));
create table Store (id bigint generated by default as identity, apeCode varchar(255), contactReference varchar(255), dealerParametersReference varchar(255), distributorParametersReference varchar(255), generalParametersReference varchar(255), groupId integer, legalForm varchar(255), mailServerReference varchar(255), managementCenter1Reference varchar(255), managementCenter2Reference varchar(255), managementCenterSuscriber varchar(255), nVAT varchar(255), rcs varchar(255), storeName varchar(255), storeReference varchar(255), primary key (id));
create table VAT (id bigint generated by default as identity, deletionDate timestamp, groupId integer, isDeletable bit, isExempted bit, vatLabel varchar(255), vatRate numeric, vatType integer, country_alpha3Code varchar(255), primary key (id));
alter table CategoryFamily_VAT add constraint FK6AE7336C7CD9FBB0 foreign key (CategoryFamily_id) references CategoryFamily;
alter table CategoryFamily_VAT add constraint FK6AE7336CE300D6E3 foreign key (vats_id) references VAT;
alter table Product add constraint FK50C664CF835F3F2E foreign key (parentProduct_id) references Product;
alter table Product add constraint FK50C664CF7CD9FBB0 foreign key (categoryFamily_id) references CategoryFamily;
alter table SaleOperation add constraint FK4ACCC4C04589BBE4 foreign key (saleTransaction_id) references SaleTransaction;
alter table SaleOperation add constraint FK4ACCC4C052FF8304 foreign key (product_id) references Product;
alter table Stock add constraint FK4C806F6AA01878D foreign key (store_id) references Store;
alter table Stock add constraint FK4C806F652FF8304 foreign key (product_id) references Product;
alter table VAT add constraint FK14B09FFF9D8B foreign key (country_alpha3Code) references Country;
CREATE INDEX IF NOT EXISTS GRPID_DATE_INDEX ON SaleOperation (groupId ASC, OPERATIONDATE ASC); 