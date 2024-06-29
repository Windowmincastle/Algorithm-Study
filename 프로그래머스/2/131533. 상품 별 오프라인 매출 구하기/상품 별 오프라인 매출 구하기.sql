SELECT
    PR.PRODUCT_CODE,
    SUM(PR.PRICE * OFF.SALES_AMOUNT) AS SALES
FROM
    PRODUCT PR
JOIN
    OFFLINE_SALE OFF ON PR.PRODUCT_ID = OFF.PRODUCT_ID
GROUP BY
    PR.PRODUCT_CODE
ORDER BY
    SALES DESC,
    PR.PRODUCT_CODE ASC;