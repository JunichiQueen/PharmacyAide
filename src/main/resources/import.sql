INSERT INTO Condition (id, conditionName) VALUES (1, 'Headache')
INSERT INTO Condition (id, conditionName) VALUES (2, 'Flu')
INSERT INTO Condition (id, conditionName) VALUES (3, 'Pertussis')
INSERT INTO Condition (id, conditionName) VALUES (4, 'Strep Throat')
INSERT INTO Condition (id, conditionName) VALUES (5, 'Hepatitis C')



INSERT INTO Medicine (id, drugName, stock) VALUES (1, 'Paracetamol', 130)
INSERT INTO Medicine (id, drugName, stock) VALUES (2, 'Aspirin', 20)
INSERT INTO Medicine (id, drugName, stock) VALUES (3, 'Lemsip', 90)
INSERT INTO Medicine (id, drugName, stock) VALUES (4, 'Lemlift', 10)
INSERT INTO Medicine (id, drugName, stock) VALUES (5, 'Oseltamivir', 40)
INSERT INTO Medicine (id, drugName, stock) VALUES (6, 'Erythromycin', 35)
INSERT INTO Medicine (id, drugName, stock) VALUES (7, 'Penicillin', 115)
INSERT INTO Medicine (id, drugName, stock) VALUES (8, 'Amoxicillin', 95)
INSERT INTO Medicine (id, drugName, stock) VALUES (9, 'Ribavirin', 10)

INSERT INTO CONDITION_MEDICINE (CONDITION_ID, MEDICINELIST_ID) VALUES (1,1)
INSERT INTO CONDITION_MEDICINE (CONDITION_ID, MEDICINELIST_ID) VALUES (1,2)
INSERT INTO CONDITION_MEDICINE (CONDITION_ID, MEDICINELIST_ID) VALUES (2,3)
INSERT INTO CONDITION_MEDICINE (CONDITION_ID, MEDICINELIST_ID) VALUES (2,4)
INSERT INTO CONDITION_MEDICINE (CONDITION_ID, MEDICINELIST_ID) VALUES (2,5)
INSERT INTO CONDITION_MEDICINE (CONDITION_ID, MEDICINELIST_ID) VALUES (3,6)
INSERT INTO CONDITION_MEDICINE (CONDITION_ID, MEDICINELIST_ID) VALUES (4,7)
INSERT INTO CONDITION_MEDICINE (CONDITION_ID, MEDICINELIST_ID) VALUES (4,8)
INSERT INTO CONDITION_MEDICINE (CONDITION_ID, MEDICINELIST_ID) VALUES (5,9)

