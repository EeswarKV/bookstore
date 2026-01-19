```md
# 📚 Bookstore Application – Execution Guide

This project consists of two main parts:

- **Backend**: Spring Boot (Java, Maven)  
- **Frontend**: React (Vite, Node.js)

Follow the steps below to run the application locally.
---

## ⚙️ Prerequisites

Make sure the following tools are installed on your machine:

- Java **17**
- Maven **3.8+**
- Node.js **18+**
- npm **9+**

Verify installations:

```bash
java -version
mvn -version
node -v
npm -v
````

---

## 🔧 Backend Setup & Execution

### 1️⃣ Navigate to backend folder

```bash
cd backend
```

---

### 2️⃣ Build all backend modules

```bash
mvn clean install
```

This command:

* Compiles all backend modules
* Runs tests
* Builds JAR files

---

### 3️⃣ Start the Spring Boot server

Navigate to the **bookstore-service** module:

```bash
cd bookstore-service
```

Run the backend server:

```bash
mvn clean spring-boot:run
```

Backend will start on:

```
http://localhost:8080
```

---

### 4️⃣ API Documentation (Swagger)

The backend exposes API documentation using **Swagger YAML**.

After the backend is running, open:

```
http://localhost:8081/swagger-ui/index.html
```

---

## 🌐 Frontend Setup & Execution

### 5️⃣ Navigate to frontend folder

Open a **new terminal** and run:

```bash
cd frontend
```

---

### 6️⃣ Install frontend dependencies

```bash
npm install
```

---

### 7️⃣ Start the frontend development server

```bash
npm run dev
```

Frontend will start on:

```
http://localhost:5173
```

(The port may vary; check terminal output.)

---

## 🔁 Application Flow

* Backend runs on **port 8080**
* Frontend runs on **port 5173**
* Frontend communicates with backend APIs
* Swagger UI can be used to test APIs independently

---

## 🧪 Common Commands Summary

### Backend

```bash
cd backend
mvn clean install

cd bookstore-service
mvn clean spring-boot:run
```

### Frontend

```bash
cd frontend
npm install
npm run dev
```

---

## 🛑 Stopping the Servers

Press `CTRL + C` in each terminal running the backend and frontend servers.

---

## 🚀 Ready to Go

Once both servers are running:

* Open browser → `http://localhost:5173`
* Browse books, add to cart, and place orders

```
```
