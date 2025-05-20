# Role-Based-Library-System
Role Based Library System - Module DEA - University Project


<h2>Project Overview</h2>
<p>This is a web-based library management system with role-based access control, allowing different user types (such as librarians, patrons, and administrators) to interact with the system according to their permissions.</p>

<h2>Technologies Used</h2>
<ul>
  <li><strong>Java:</strong> Version 22</li>
  <li><strong>Maven:</strong> For dependency management and build automation</li>
  <li><strong>MySQL:</strong> Database (MariaDB 10.4.32)</li>
  <li><strong>JSP/JSTL:</strong> For dynamic web content</li>
  <li><strong>Apache Tomcat:</strong> Version 10.1.39 as the application server</li>
</ul>

<h2>Project Structure</h2>
<p>This project follows a standard Maven directory structure:</p>
<pre>
RoleBasedLibrarySystem/
├── src/
│   ├── main/
│   │   ├── java/        # Java source code
│   │   ├── resources/   # Application resources
│   │   └── webapp/      # Web application files (JSP, CSS)
│   └── test/            # Test files
├── pom.xml              # Maven configuration
├── .mvn/                # Maven wrapper configuration
├── mvnw                 # Maven wrapper script (Unix/Linux)
└── mvnw.cmd             # Maven wrapper script (Windows)
</pre>

<h2>Database Configuration</h2>
<p>The system connects to a MySQL database with the following configuration:</p>
<ul>
  <li><strong>Database Name:</strong> librarydb</li>
  <li><strong>Host:</strong> localhost</li>
  <li><strong>Port:</strong> 3306</li>
  <li><strong>Driver:</strong> com.mysql.cj.jdbc.Driver</li>
</ul>

<h2>Setup Instructions</h2>
<ol>
  <li><strong>Prerequisites:</strong>
    <ul>
      <li>JDK 22</li>
      <li>MySQL/MariaDB</li>
      <li>Apache Tomcat 10.1 or higher</li>
    </ul>
  </li>
  <li><strong>Database Setup:</strong>
    <ul>
      <li>Create a database named <code>librarydb</code></li>
      <li>Run the database scripts (included in the project) to set up the schema</li>
    </ul>
  </li>
  <li><strong>Build the Project:</strong>
    <pre>./mvnw clean package</pre>
    Or on Windows:
    <pre>mvnw.cmd clean package</pre>
  </li>
  <li><strong>Deploy to Tomcat:</strong>
    <ul>
      <li>Copy the generated WAR file from <code>target/</code> directory to Tomcat's <code>webapps</code> directory</li>
      <li>Or use the IDE integration to deploy directly to Tomcat</li>
    </ul>
  </li>
  <li><strong>Access the Application:</strong>
    <p>Once deployed, access the application at: <code>http://localhost:8080/RoleBasedLibrarySystem</code></p>
  </li>
</ol>

<h2>Features</h2>
<ul>
  <li><strong>User Authentication and Authorization</strong> - Different access levels based on user roles</li>
  <li><strong>Book Management</strong> - Add, edit, delete, and search for books</li>
  <li><strong>Member Management</strong> - Register new members, update profiles</li>
  <li><strong>Borrowing System</strong> - Check-out and check-in books</li>
  <li><strong>Reservation System</strong> - Reserve books that are currently unavailable</li>
  <li><strong>Fine Management</strong> - Calculate and manage fines for late returns</li>
  <li><strong>Reports</strong> - Generate various reports for library administration</li>
</ul>

<h2>Development</h2>
<p>This project is developed using IntelliJ IDEA with Maven integration. It uses the Maven Wrapper for easy build process management without requiring a separate Maven installation.</p>
