## GoodReads Random Book Selector
This is useful for anyone that doesn't know what to read next. If you have GoodReads, you probably have hundreds of books on your to-read bookshelf, and may want to roll the dice, if you will, to randomly select your next book. If you don't have GoodReads, you can randomly select a book off a good friend's book shelf.

## How it works
The only input is the user-id and the name of the book shelf to randomly select from.  You will also need a key, which you can obtain from the GoodReads website. *You'll have to edit the script to put your key in.* https://www.goodreads.com/api

## If you don't have scala...
The easiest way to install it is with homebrew. [Or check out other ways to download on the scala website.](https://www.scala-lang.org/download/)
```
brew update
brew install scala
```

## Compiling
From the terminal run 
``` 
scalac GoodReads-BookSelector/bookSelector.scala
```

## Running
From terminal run:
```
scala bookSelector
``` 
#### And respond to prompts:
1) a user-id, which can be a user-id from any GoodReads user. To get a user-id, simply go to your profile, or another person's profile and the id will be in the web address. 
For example, the address of my profile is: https://www.goodreads.com/user/show/4333445-arielle and my user-id is 4333445.
2) the name of a book shelf from the profile of the user. Most people have a to-read book shelf, but you may also be interested in selecting a random book from your classics book shelf. the world is your oyster.
