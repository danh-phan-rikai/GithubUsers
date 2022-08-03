This project uses jetpack compose for building User Interface, it is divided into 3 layers:
- ui layer: contains classes which construct UI
- domain layer: business logic
- data layer: data provider
Domain layer is center, ui and data layers depends on it
Abstract repository is used for dependency inversion between domain and data layer
Each screen has corresponding State file which contains data to present to UI, change in data will be updated to UI automatically
*Simple code for simple things*
