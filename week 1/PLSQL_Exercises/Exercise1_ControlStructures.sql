DECLARE
    CURSOR c_elderly_customers IS
        SELECT CustomerID 
        FROM Customers 
        WHERE Age > 60;
BEGIN
    FOR v_customer IN c_elderly_customers LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = v_customer.CustomerID;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest rate discount applied for customers over 60.');
END;
/

DECLARE
    CURSOR c_all_customers IS
        SELECT CustomerID, Balance 
        FROM Customers;
BEGIN
    FOR v_customer IN c_all_customers LOOP
        IF v_customer.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = v_customer.CustomerID;
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status updated for eligible customers.');
END;
/

DECLARE
    CURSOR c_due_loans IS
        SELECT l.LoanID, c.Name, l.DueDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR v_loan IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_loan.Name || 
                             ', your loan (' || v_loan.LoanID || 
                             ') is due on ' || TO_CHAR(v_loan.DueDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/
