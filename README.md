# shipping_eligibility

instruction to run application on mac terminal: ./mvnw spring-boot:run 

Pre-installation note and dependencies:
---------------------------------------
-java 1.8 version 
-apache-maven-3.6.3. 
Note: Java home and M2_HOME should be updated in the profile)

Curl command for itemEligibilityService:
----------------------------------------
POST /v1/isItemEligible HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 76c7b385-6cef-e0c0-7861-579ed5b36ba7

    {
      "seller": "Arther",
      "category": 123,
      "price":201.00
    }
    
Notes:
------
Currently this service returns a response with all eligibility criterias that could be further enhanced to an api and can also be used as a basis for browser based tooling for eBay administrators.

Improvements:
-------------
configurable properties for now are defined in application.properties file which can be further enhanced to externalize configuration as well as if there are more propertirs added in future it will be easier to persist them in the db.

Rules are implemented as part of ShippingEligibilityRule which can accomodate more rules in the future.

example of configuration rule is in ItemEligibilityRuleImpl.java implementation 
and example of non-configurable rule is in SeasonEligibilityRuleImpl


Below is an example response format for api:
-------------------------------------
    "IS_ITEM_ELIGIBLE": false, (will be true for Eligible criterias)
    "ELIGIBILITY_CRITERIA": {
        "PRE_APPR_CATEGORY": [
            12,
            23,
            19
        ],
        "MIN_PRICE": 200,
        "ENROLLED_SELLERS": [
            "Mattel",
            "Arther",
            "luckyline1945"
        ]
    },
    "ERROR": {
        "message": "ITEM_INELIGIBLE_FOR_SHIPPING",(will be null for eligible)
        "details": null,
        "status": 403 
    }


