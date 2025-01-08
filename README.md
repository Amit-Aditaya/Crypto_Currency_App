# Cryptocurrency App

This is a simple cryptocurrency app built using Kotlin and Jetpack Compose with Clean Architecture principles. The app fetches data from the [Coin Paprika API](https://api.coinpaprika.com/) and displays the following features:

Download apk :- https://drive.google.com/file/d/1FhuX4tmXlT2CzlQwxq0V8nb-KdUs0IXX/view?usp=sharing

## Features

- **List of Cryptocurrencies**:
  - Displays a list of cryptocurrencies with their names, symbols, and statuses.

- **Cryptocurrency Details**:
  - Detailed information about a selected cryptocurrency, including tags and team members.

- **Latest Twitter Feeds**:
  - Displays the latest Twitter feeds related to the selected cryptocurrency.

## Screenshots

### Cryptocurrency List
<img src="https://github.com/user-attachments/assets/0a59213d-0776-4b78-b3f2-cac6b8b399cb" alt="Game Board" width="400">


### Cryptocurrency Details
<img src="https://github.com/user-attachments/assets/51dff2c5-4f0b-40fc-a4b2-fcd4383e3ea3" alt="Game Board" width="400">


### Twitter Feeds
<img src="https://github.com/user-attachments/assets/35697627-8943-4030-85d0-54831cd09e0f" alt="Game Board" width="400">


## Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Clean Architecture**
  - MVVM (Model-View-ViewModel) pattern
- **Hilt** for Dependency Injection
- **Retrofit** for API calls
- **Coroutines** for asynchronous programming
- **Coil** for image loading

## API

The app uses the [Coin Paprika API](https://api.coinpaprika.com/) to fetch cryptocurrency data, including:
- Coins list: `/v1/coins`
- Coin details: `/v1/coins/{coin_id}`
- Twitter feeds: `/v1/coins/{coin_id}/twitter`

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/Amit-Aditaya/Crypto_Currency_App.git

2. Open the project in Android Studio.

3. Build and run the project on an emulator or a physical device.


## How It Works
1. The app fetches data from the Coin Paprika API using Retrofit.
2. Data is mapped to domain models and passed to the presentation layer.
3. The UI is built with Jetpack Compose and adheres to Material Design principles.
4. Twitter feeds for cryptocurrencies are displayed using a scrollable list.

# Contributions
Contributions are welcome! Feel free to submit a pull request or open an issue if you encounter any bugs or have feature requests.

# Contact
For inquiries or support, contact me at amit.aditaya99@gmail.com







   
