# Printshop App

## Overview

The Printshop App is a Java-based application designed to simplify the file upload and download process for print shops. This project leverages Spring Boot and Hibernate to manage shop registrations and file transfers seamlessly. Users can upload files directly to a shop's designated directory by scanning a QR code provided by the shop. This eliminates the need for traditional methods like email or WhatsApp for file transfers.

## Key Features

1. **Shop Registration**:
   - Shop owners can register their shops, generating a unique QR code for file uploads.

2. **File Uploads**:
   - Customers scan the shop's QR code to upload files directly to the shop's directory.

3. **File Downloads**:
   - Shop owners can download uploaded files through an easy-to-use interface.

4. **Unique Directories**:
   - Each shop has its own folder for uploaded files, ensuring proper organization and privacy.

5. **Scheduled Sync**:
   - Files from multiple shops can be periodically synced and fetched.

## Technologies Used

- **Backend**: Java, Spring Boot, Hibernate
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **Build Tool**: Maven
- **Packaging**: WAR

## Installation & Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven
- MySQL database
- Eclipse IDE or any preferred IDE

### Steps to Setup Locally

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. Import the project into Eclipse:
   - File > Import > Maven > Existing Maven Projects > Select the project folder.

3. Configure MySQL:
   - Create a database named `printshop`.
   - Update the database credentials in `src/main/resources/application.properties`.

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Deploy the `.war` file:
   - Locate the `.war` file in the `target` folder.
   - Deploy it to a Tomcat server or any application server.

6. Access the app:
   - Open your browser and navigate to `http://localhost:8080`.

## Deployment on Render

To deploy the application on Render:

1. Log in to [Render](https://render.com/).
2. Create a new Web Service.
3. Upload the `.war` file from the `target` directory.
4. Set the start command to `java -jar target/YourAppName.war`.
5. Configure environment variables for database connection.
6. Deploy the service and access the app via the provided Render URL.

## Usage

1. **Register Shop**:
   - Enter the shop name to register and generate a QR code.

2. **Upload Files**:
   - Customers scan the QR code and upload files directly.

3. **Download Files**:
   - Shop owners can log in and download files uploaded by customers.

## Project Structure

- **`src/main/java`**: Contains the Java source code.
- **`src/main/resources`**: Configuration files.
- **`target`**: Compiled `.war` file.
- **`uploads`**: Folder for storing uploaded files.

## For Your Resume

**Project Name**: Printshop App  
**Description**: Developed a Java-based web application to streamline file transfers for print shops. The app enables customers to upload files directly via QR codes, simplifying operations and enhancing customer experience.  
**Technologies Used**: Java, Spring Boot, Hibernate, MySQL, Maven  
**Notable Features**: QR code integration, unique shop directories, REST APIs for file management.

---

For any questions or contributions, feel free to open an issue or contact the project owner.


