# Ibuy Application backend-(Java-REST APIs)

## REST APIS

..1)GET - To get a customer detail - /getcust/{custname}  
....eg:- /getcust/cust1 gives you json response {"id":,"customerName":,"email":,"password":,"phone":}


..2)POST - Sign up - /signup  
....pass the JSON input as follows {"customerName":,"email":,"password":,"phone":}


..3)POST - Sign In - /signIn
....pass the JSON input as follows { "customerName": ,"password": }


..4)GET - Get All products - /getAllProducts
....eg-/getAllProducts  gives you list of items in JSON Format {[{"id":1,"productName":"book","productprice":5,"weight":10,"barcode":"01020304","aisleNo":13},{"id":2,"productName":"Waterbottles","productprice":5,"weight":10,"barcode":"01020306","aisleNo":14},{"id":3,"productName":"Chips","productprice":3,"weight":5,"barcode":"01020301","aisleNo":1}]}


..5)GET - Get Product details based on barcode scan - /getProduct/{barcode}
....eg-/getProduct/01020304 --gives JSON response {"id":1,"productName":"book","productprice":5,"weight":10,"aisleNo":13}


..6)GET - Get Product Aisle Number -/getProductAilse/{productname}
....eg-/getProductAilse/book --gives JSON response {{"Aisleno":13}


..7)POST - Pay the bill -/pay pass the JSON object as follows 
	
	{
    "cardHolderName":"cust1",
    "CardNumber": 4545456655988788,
    "amountPaid":34,
    "qrcode": "hello word hello hello",
    
    "Products_Purchased": [
        {
            "productid":1 ,
            "productName":"Ball",
            "quantity":2
        },
        {
            "productid":2 ,
            "productName" :"Hat",
            "quantity":3
        }]
	}
	
..8)GET - To get Bill using QR code -/getQRcode/{qrcode}     for example- /getQRcode/hu
	
	{
    "PaymentTransactionId": 91,
	"Billprinted": false,
    "Amount": 14,
    "orders": [
        {
            "ProductName": "Ball",
            "Productprice": 4,
            "Quantity": 4,
            "ProductId": 1,
            "Totalcostofquantity": 16
        },
        {
            "ProductName": "Hat",
            "Productprice": 7,
            "Quantity": 6,
            "ProductId": 2,
            "Totalcostofquantity": 42
        }
    ],
    "Orderid ": 89
	}
	
	example -/getQRcode/3
	
	{
    "PaymentTransactionId": 85,
    "Billprinted": true,
    "Amount": 28,
    "orders": [
        {
            "ProductName": "Nivea men",
            "Productprice": 0,
            "Quantity": 3,
            "ProductId": 2,
            "Totalcostofquantity": 0
        },
        {
            "ProductName": "NeviaLotion",
            "Productprice": 0,
            "Quantity": 3,
            "ProductId": 2,
            "Totalcostofquantity": 0
        },
        {
            "ProductName": "Deo",
            "Productprice": 20,
            "Quantity": 3,
            "ProductId": 2,
            "Totalcostofquantity": 60
        }
    ],
    "Orderid ": 83
}


..9)GET -To get productprice - getProductprice/{productName} for example - getProductprice/ball

	{
    "productprice": 4
	}
	
..10)POST - Acknowledgement to the bill printed - acknowledge  passing qr code as JSON string.
  {
	"qrcode":"3"

  }
  
  Reponse -
  {
    "result": true
  }

 ..11) GET - Whether to know bill printed or not based on qrcode -/getbillprinted/hu
	
	Response-
	{
		"result":false
	}
 
 
  
