
# 🚀 Java OOP Projects — Dockerized

### 📦 Project Overview  
A collection of **advanced Java OOP projects** for inventory management, online shopping, and vehicle insurance.  
Each project is fully containerized with **Docker** for seamless deployment and testing.

---

## 📁 Included Projects

| Project Name         | Description                                                                 |
|----------------------|-----------------------------------------------------------------------------|
| 🏬 **Stock Management**      | Manage warehouse inventory, suppliers, and stock items interactively.         |
| 🛍️ **Online Shopping System** | Simulate an e-commerce experience with cart, checkout, and categories.       |
| 🚗 **Insurance System**       | Manage vehicle insurance policies, file claims, and generate reports.         |

---

## 🛠️ Quick Start: Clone, Build & Run Locally

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Prom004/OOP-Project.git
cd OOP-Project
```

### 2️⃣ Build a Project’s Docker Image  
Replace `<ProjectDir>` and `<image-name>` as needed:
```bash
cd <ProjectDir>
docker build -t <image-name> .
```

### 3️⃣ Run the Docker Container
```bash
docker run --rm -it <image-name>
```

#### 🔍 Examples:
```bash
docker run --rm -it stockmanagement-app
docker run --rm -it onlineshopping-app
docker run --rm -it motorinsurance-app
```

---

## ☁️ Run from Docker Hub (No Build Needed)

Skip building locally — just pull the image and run!

### 🧲 1. Pull the Image

```bash
# 📦 Stock Management
docker pull prom004/oop-projects:stockmanagement

# 🛒 Online Shopping System
docker pull prom004/oop-projects:onlineshopping

# 🚘 Insurance System
docker pull prom004/oop-projects:motorinsurance
```

### ▶️ 2. Run the Project

```bash
# 📦 Stock Management
docker run --rm -it prom004/oop-projects:stockmanagement

# 🛒 Online Shopping System
docker run --rm -it prom004/oop-projects:onlineshopping

# 🚘 Insurance System
docker run --rm -it prom004/oop-projects:motorinsurance
```

---

### 🔗 Docker Hub Repo  
🔍 [https://hub.docker.com/repository/docker/prom004/oop-projects](https://hub.docker.com/repository/docker/prom004/oop-projects)

---

## 👤 Author

**Promise IZERE INEZA**  
🎓 Software Engineering Student @ AUCA  
🆔 Student ID: `26577`

---

Let me know if you'd like a badge version or GitHub Markdown styling as well!
