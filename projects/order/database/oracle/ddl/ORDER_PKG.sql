
This Pl sql script prints the date   */
DECLARE
V_CURR_DATE DATE;

BEGIN
FOR RECORD IN (
SELECT CURRENT_TIMESTAMP FROM DUAL )

LOOP 

DBMS_OUTPUT.PUT_LINE('The current date '|| RECORD.CURRENT_TIMESTAMP );

END LOOP;
END;
   /
