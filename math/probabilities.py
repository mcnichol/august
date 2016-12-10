from __future__ import division
import random as rand

cardDeck = [2,2,2,2,2,2,2,2,2,3]
resultCount = {2: 0, 3:0}
totalRuns = 100000000

def main():
    shuffleAndDrawCards(totalRuns)

	#Get the probabilities of 2 against total runs
    print "Chance of the Card being 2 is: " + getProbabilityForCard(2) + "%"
	#Get the probabilities of 3 against total runs
    print "Chance of the Card being 3 is: " + getProbabilityForCard(3) + "%"

    print resultCount

def getProbabilityForCard(cardValue):
    return str(int((resultCount[cardValue] / totalRuns * 100)))

def shuffleAndDrawCards(numOfTimes):
    for x in range(numOfTimes):
        resultCount[cardDeck[getRandomNumber()]] += 1

def getRandomNumber():
    return rand.randint(0,9)

if __name__ == "__main__":
    main()
