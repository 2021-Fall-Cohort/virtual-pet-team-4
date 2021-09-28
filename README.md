# Required Tasks
## VirtualPetShelterApp Class
- Create a main method that...
  - [x] implements a game loop
  - [x] asks for user input
  - [x] writes output to the console
  - [x] calls VirtualPetShelter's tick method after each interaction
- Avaliable user interface actions should include (at minimum)
  - [x] feeding all the pets
  - [x] watering all the pets
  - [x] playing with an individual pet, which should display a list of pet names and descriptions, allowing a user to select one
  - [x] allow adoption of a pet, which should display a list of pet names and descriptions, allowing a user to select one
  - [x] allow intake of a pet. prompting the user for the pet's information

## VirtualPetSheleter Class
- [x] include appropriate instance variables to store the pets who reside at the shelter
- [x] include methods that:
  - [x] return a collection of all the pets in the shelter
  - [x] return a specific pet given its name
  - [x] allow intake of a homeless pet
  - [x] feed all of the pets in the shelter
  - [x] water all of the pets in the shelter
  - [x] plays with an individual pet in the shelter

## VirtualPet class
- [x] You will need to create a VirtualPet class.
- [x] Create at least three instance variables (aka attributes aka properties aka fields).
- [x] Create at least three methods (messages you send to your pet).
- [x] Create a tick() method that represents the passage of time.

## VirtualPetApp class
- [x] Create a main method.
- [x] implements a game loop.
- [x] asks for user input.
- [x] writes output to the console.


## Stretch Tasks
- [ ] Give the pet the ability to take care of some of its own needs.

Pets are not robots - they usually have some sort of self-determination! When tick() is called, you might want to have your pet take a look at its needs and address one, prioritizing whichever need is highest. You could also make your pet uncooperative - when the user tries to feed the pet, for example, you might make the pet refuse to eat if it is bored. Remember how we created an instance of the Random class to create a random number generator? You might want to incorporate that.

- [x] Create a visual representation of your pet.

Rather than using numbers to convey your pet’s status, you could have some sort of visual representation of the pet. I.e., instead of printing hunger: 50, you could use smileys or ASCII art to show hunger when hunger >= 50.
