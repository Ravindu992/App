# Project Tasks: Android and React Native App Development

## ✅ PART 01 – Android Development (Marks: 60)

### 📱 App: “MultiLayout UI Android App”

---

### 📌 General Features:
*   Multiple layouts (Linear, Frame, Constraint, Relative)
*   Bottom Navigation Bar
*   SQLite database integration

---

### 🔸 Question 1: Home Page (Linear Layout + Bottom Navigation)

**Step-by-Step:**

1.  **Open Android Studio → Create a new project.**
2.  Set `LinearLayout` (vertical) as your main layout.
3.  **Add:**
    *   Text fields (`EditText`) for input (e.g., Name, Age).
    *   Labels (`TextView`) like "Enter Name".
4.  **Add a `BottomNavigationView` with 3 options:**
    *   Frame Layout
    *   Constraint Layout
    *   Relative Layout
5.  Set a background image using `android:background="@drawable/your_image"` in the layout XML.

**Provide screenshots of:**
*   UI layout with text fields.
*   Bottom navigation bar.

---

### 🔸 Question 2: Frame Layout (User Profile Page)

**Step-by-Step:**

1.  Create a new `Activity`.
2.  Use `FrameLayout`.
3.  **Add components:**
    *   `ImageView`: A sample user profile picture.
    *   `TextView`: “Welcome, [User Name!]”
    *   `Button`: “Edit Profile”

**Provide screenshots of:**
*   UI design.
*   Java/XML code.

---

### 🔸 Question 3: Constraint Layout + Nested Linear Layout (User Form Page)

**Step-by-Step:**

1.  Create another `Activity` with `ConstraintLayout`.
2.  **Add:**
    *   A `TextView`: “Student Form”
    *   A `LinearLayout` inside the `ConstraintLayout` with:
        *   Labels + Text fields for Name, Email, Phone.
        *   Small icons using `ImageView` next to each field.
    *   Two `Buttons`: Submit and Clear.
3.  Use proper constraints to align all items.

**Provide screenshots of:**
*   UI structure.
*   Code implementation.

---

### 🔸 Question 4: Relative Layout (Dashboard Page)

**Step-by-Step:**

1.  Create a new `Activity` using `RelativeLayout`.
2.  **Add:**
    *   `TextViews`: “Dashboard”, “Notifications”, “Account Status”
    *   `Buttons`: “View Profile”, “Settings”
    *   `EditText`: Search bar
3.  A background image for the activity.

**Provide screenshots of:**
*   UI layout.
*   Java/XML code.
*   Running app with all screens visible.

---

### 🔸 Question 5: SQLite Database (Store Form Data)

**Step-by-Step:**

1.  Create a local SQLite database.
2.  **Set up a table named `students` with:**
    *   `ID` (Primary Key, auto-increment)
    *   `Name`, `Email`, `Phone`
3.  **When the `Submit` button is clicked:**
    *   Insert form data into the database.
    *   Optionally display a success message (e.g., using `Toast`).
4.  **Implement CRUD:**
    *   **Create** → Insert data
    *   **Read** → View data
    *   **Update** → Edit existing entry
    *   **Delete** → Remove entry

**Provide screenshots of:**
*   Database structure.
*   Code implementation (SQLiteHelper, CRUD logic).

---
---

## ✅ PART 02 – Cross-Platform React Native App (Marks: 40)

### Tools:
*   VSCode
*   Expo CLI
*   React Navigation

---

### 🔸 Question 1: Home Screen

**Step-by-Step:**

1.  In VSCode, create a React Native project using `npx create-expo-app`.
2.  Create a file: `HomeScreen.js`.
3.  **Add:**
    *   A `Text` component: “Welcome to the App!”
    *   A `Button`: Navigate to Profile screen.
4.  Add background color or image.
5.  Set up React Navigation (use `@react-navigation/native` and `@react-navigation/native-stack`).

**Provide screenshots of:**
*   UI layout of Home screen.
*   Navigation code (stack navigation).

---

### 🔸 Question 2: Profile Screen

**Step-by-Step:**

1.  Create `ProfileScreen.js`.
2.  **Add:**
    *   `Text`: Show Name and Email.
    *   A `Button`: “Edit Profile”.
3.  Use navigation to go back to Home Screen.

**Provide screenshots of:**
*   Profile UI.
*   Navigation working (between Home ↔ Profile).

---

### 🔸 Question 3: Run App on Web and Emulator

**Step-by-Step:**

1.  **Run the app on:**
    *   **Web:** `npx expo start --web`
    *   **Emulator:** Android Studio AVD or Expo Go app on a physical device.
2.  Check that navigation and layout work correctly.

**Provide screenshots of:**
*   App running on Web.
*   App running on Emulator or Phone.