INSERT INTO Condition (id, conditionName) VALUES (1, 'Headache')
INSERT INTO Condition (id, conditionName) VALUES (2, 'Flu')


INSERT INTO Medicine (id, drugName, stock) VALUES (1, 'Paracetamol', 130)
INSERT INTO Medicine (id, drugName, stock) VALUES (2, 'Aspirin', 20)
INSERT INTO Medicine (id, drugName, stock) VALUES (3, 'Lemsip', 90)
INSERT INTO Medicine (id, drugName, stock) VALUES (4, 'Lemlift', 10)
INSERT INTO Medicine (id, drugName, stock) VALUES (5, 'Oseltamivir', 40)

INSERT INTO CONDITION_MEDICINE (CONDITION_ID, MEDICINELIST_ID) VALUES (1,1)
INSERT INTO CONDITION_MEDICINE (CONDITION_ID, MEDICINELIST_ID) VALUES (1,2)
