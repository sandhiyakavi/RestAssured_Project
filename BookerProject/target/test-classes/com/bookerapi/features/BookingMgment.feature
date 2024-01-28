Feature: Manage of Restful BookerAPI

Scenario: HealthCheck for BookingAPI
When get bookingapi health
Then Validate response code as 201

Scenario: Create Booking
When Create booking with string body '{"firstname": "Jim","lastname": "Brown","totalprice": 111,"depositpaid": true,"bookingdates": {"checkin": "2018-01-01","checkout": "2019-01-01"},"additionalneeds": "Breakfast"}'
Then Validate response code as 200
Then Validate the schema of the response using file 'CreateCRSchema.json'

Scenario: Get booking with BookingId
When get Booking detail by ID
Then Validate response code as 200

Scenario Outline: Create Booking with Multiple Files
When create booking with file '<fileName>'
Then Validate response code as 200
Examples:
|fileName|
|CreateBooking1.json|
|CreateBooking2.json|

Scenario: Update Booking
When update Booking with file 'UpdateBooking.json'
Then Validate response code as 200

Scenario: Get All BookingIds with Query params
When get BookingIds with queryparams
|lastName|brown|
|depositpaid|true|
Then Validate response code as 200







