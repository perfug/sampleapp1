Actions complementaire
-----------------------
Génération des fichiers de données
1) Lancer 3 instances SQLFire l'une sur localhost:1527
2) Lancer mvn benerator:generate

Actions complementaires
-----------------------
Sur chaque fichier CSV si vous les avez regénérés. Si vous les avez trouvés sur le volume octo-newsql-data2A ou que je vous les ai transmis ils sont déjà OK.

1) Supprimer la ligne d'entête
sed -i '1d' CategoryFamily.csv
2) Mettre les dates au format 
sed -E -i "s/T([0-9]{2}:[0-9]{2}:[0-9]{2})./ \1/g" CategoryFamily.csv
3) Ajouter un saut de ligne à la fin du fichier sinon il y a une erreur
sed -i '$ a\n' CategoryFamily.csv

4) Sur SaleTransaction on a eu la bonne idée de ne pas générer la colonne de totale car elle est calculée. Du coup, il faut la rajouter dans le CSV.
sed -i "s/\(\([^,]*,\)\{16\}\)/\1,/" SaleTransaction.csv
Idem sur Sale Operation pour 2 colonnes
sed -i "s/\(\([^,]*,\)\{2\}\)\(\([^,]*,\)\{15\}\)/\1,,,\3,/" SaleOperation.csv

5) Sur SQLFire
connect client '<IP privee>;load-balance=false;read-timeout=0' /* 
IP privée car c'est là dessus qu'en bindé SQLFire, 
pas de load-balancing car l'autre noeud ne trouvera pas le fichier, 
pas de timeout car c'est long /*

run '/sqlfire-data2/schema_distributed_overflow.sql';
run '/sqlfire-data2/test-data.sql';

call syscs_util.import_table_ex('APP' /* schema */,
'CategoryFamily' /* table */,
'/sqlfire-data2/CategoryFamily.csv' /* file path as seen by server */,
',' /* field separator */,
NULL,
NULL,
0,
0 /* don't lock the table */,
6 /* number of threads */,
0,
NULL /* custom class for data transformation or NULL to use the default inbuilt Import class */,
NULL);

6) Faire un update des tables
UPDATE SaleTransaction st SET totalAmount = (SELECT SUM(so.amount) from SaleOperation so where so.saleTransaction_id=st.id);
UPDATE SaleOperation so SET productLabel = (SELECT productLabel from Product p where p.id=so.product_id);
=======
#!/bin/bash


declare -a arr=(CategoryFamily Product Store VAT CategoryFamily_VAT Stock SaleTransaction SaleOperation)
 
for i in ${arr[@]}
do
    sed -i '1d' $i.csv
    sed -E -i "s/T([0-9]{2}:[0-9]{2}:[0-9]{2})./ \1/g" $i.csv
    sed -i '$ a\ ' $i.csv
done


======
Jouer dans SQLFire le fichier newsql/data/src/main/resources/db/sqlfire/LoadData.sql



