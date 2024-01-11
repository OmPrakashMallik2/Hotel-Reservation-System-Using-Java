# Hotel Management System

Hotel Management System is a simple Java console application that allows users to manage hotel reservations. Users can book rooms, view reservations, get room numbers, update reservations, and delete reservations.

## Getting Started

1. **Prerequisites:**
   - Java JDK installed
   - MySQL database

2. **Database Setup:**
   - Create a MySQL database named `hotel_db`.
   - Set up a table named `reservations` with the specified columns:
     - `reservation_id` (auto_increment, primary key)
     - `guest_name` (varchar(255), not null)
     - `room_number` (int, not null)
     - `contact_number` (varchar(10), not null)
     - `reservation_date` (timestamp, default generated)

3. **Configuration:**
   - Open `HotelManagementSystem.java` and update the database connection parameters (`url`, `username`, `password`) to match your MySQL configuration.

4. **Running the Application:**
   - Compile and run the `HotelManagementSystem.java` file.

## Features

1. **Book A Room:**
   - Allows users to book a room by providing their name, room number, and mobile number.

2. **View Reservations:**
   - Displays a list of all reservations in the database.

3. **Get Room Number:**
   - Retrieves and displays the room number for a given reservation ID.

4. **Update Reservation:**
   - Allows users to update reservation details such as name, room number, and contact number.

5. **Delete Reservation:**
   - Checks out a guest by deleting their reservation based on the room number.

## Usage

1. Choose an option from the menu by entering the corresponding number.
2. Follow the prompts to input necessary information.
3. View the results and follow any additional instructions.

## Contributing

If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them with clear and concise messages.
4. Push your changes to your fork and submit a pull request.
