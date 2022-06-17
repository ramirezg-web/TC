package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int numberOfRacoons=3;
		int numberToDinner=2;
		int numberOfLeft=numberOfRacoons-numberToDinner;


        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers=5;
		int numberOfBees=3;
		int differenceOfNumbers=numberOfFlowers-numberOfBees;


        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int numberOfPigeons=1;
		int numberOfNew=1;
		int numberOfTotal=numberOfPigeons+numberOfNew;

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int numberOfOwls= 3;
		int numberOfOwl=2;
		int numberTotalOwls=numberOfOwls+numberOfOwl;


        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int numberOfBeavers=2;
		int numberOfSwim=1;
		int totalNumberLeft=numberOfBeavers-numberOfSwim;



        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int numberOfTucans=2;
		int numberOfNewts=1;
		int numberOfTotalts=numberOfTucans+numberOfNewts;

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numberOfSq=4;
		int numberOfNuts=2;
		int numberOfAnswer= numberOfSq-numberOfNuts;

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double valueOfQuarters=1;
		double valueOfDimes=1;
		double valueOfNickles=2;
		double total;
		total=valueOfQuarters*0.25+ valueOfDimes*.10 + valueOfNickles*.05;

        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int numberBakedBreier=18;
		int numberBakedMacAdams=20;
		int numberBakedFlannerys=17;
		int result;
		result=numberBakedFlannerys+numberBakedBreier+numberBakedMacAdams;

        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double yoyo=.24;
		double whistle=.14;
		double spending;
		spending=yoyo+whistle;


        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int numberOfLarge=8;
		int numberOfMini=10;
		int allTogether;
		allTogether=numberOfLarge+numberOfMini;


        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int inchesOfSnowh=29;
		int inchesOfSchoolsnow=17;
		int moreSnow;
		moreSnow=inchesOfSnowh-inchesOfSchoolsnow;

        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */

		double start=10;
		double numberSpentToy=3+2;
		double numberSpentPen=2;
		double leftOver;
		leftOver=start-numberSpentToy;

        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int numberOfMarbles=16;
		int numberLost=7;
		int numberOfMarble=numberOfMarbles-numberLost;


        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int numberOfSeashells=19;
		int numberOfWant=25;
		int numberLeftOver= numberOfWant-numberOfSeashells;

        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int numberOfBalloonst=17;
		int numberOfGreen=8;
		int totalR;
		totalR=numberOfBalloonst-numberOfGreen;


        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int numberOfBookss=38;
		int numberOfBooksadded=10;
		int totalBooks;
		totalBooks=numberOfBooksadded+numberOfBookss;


        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int numberOfLegs=6;
		int numberOfBeees=8;
		int totalLegs;
		totalLegs=numberOfLegs*numberOfBeees;

        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double priceOfIce=.99;
		double numberOfIce=2;
		double creamCosts;
		creamCosts=priceOfIce*numberOfIce;


        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int numberOfNeed=125;
		int numberOfHave=64;
		int complete;
		complete=numberOfNeed-numberOfHave;


        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int numberOfHad=38;
		int hiltLostN=15;
		int leftm;
		leftm=numberOfHad-hiltLostN;


        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int drive=78;
		int stopped=32;
		int more;
		more=drive-stopped;


        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int minutes=90;
		int saturday=45;
		int totalMins;
		totalMins=minutes+saturday;

        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		double costOfHd=.50;
		double purchased=6;
		double pay;
		pay=purchased*costOfHd;


        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int hMoney=50;
		int penC=7;
		int possible;
		possible=hMoney/penC;


        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int seenButterFly=33;
		int orangeButFly=20;
		int redButterflyS;
		redButterflyS=seenButterFly-orangeButFly;

        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double clerk=1;
		double bar=.54;
		double change;
		change=clerk-bar;

        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int numberOfTrees=13;
		int numberOfPlanted=12;
		int totalTrees;
		totalTrees=numberOfTrees+numberOfPlanted;

        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int days=2;
		int hours=24;
		int hoursAmount;
		hoursAmount=days*hours;

        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberOfCousins=4;
		int numberOfGums=5;
		int gumNeeded;
		gumNeeded=numberOfCousins*numberOfGums;

        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double danMoney=3;
		double candyC=1;
		double moneyLeftO;
		moneyLeftO=danMoney-candyC;


        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int numberOfBoats=5;
		int numberOfPeople=3;
		int numberTotalBP;
		numberTotalBP=numberOfBoats*numberOfPeople;


        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int numberOfL=380;
		int numOfL=57;
		int totalLegos;
		totalLegos=numberOfL-numOfL;

        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int wantToB=83;
		int alReaB=35;
		int leftToBake;
		leftToBake=wantToB-alReaB;

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int numWilLC=1400;
		int numLuC=290;
		int howManyMore;
		howManyMore=numWilLC-numLuC;


        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int numbOfSticks=10;
		int numOfPage=22;
		int totSticks;
		totSticks=numbOfSticks*numOfPage;

        /* Exercise 39
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double totalCup=96;
		double totChild=8;
		double share;
		share=totalCup/totChild;

        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */

		int totalGinCookie=47;
		int totalCoJ=6;
		int jars;
		jars=totalGinCookie%totalCoJ;


        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int totalCroissantsPreppared=59;
		int totalNeiG=8;
		int prepparedLeftOver;
		prepparedLeftOver= totalCroissantsPreppared % totalNeiG;

        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int totalOatCo=276;
		int numCoT=12;
		int totalTrayN;
		totalTrayN=totalOatCo/numCoT;


        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totPrezP=480;
		int toEquS=12;
		int prePrez;
		prePrez=totPrezP/toEquS;


        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int mLemCup=53;
		int leftLemC=3;
		int givenAway=mLemCup/leftLemC;


        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carrotSticksPrepped=74;
		int equallyServedTo=12;
		int leftUneattenE;
		leftUneattenE= carrotSticksPrepped % equallyServedTo;


        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

		int totalTeddyBears=98;
		int maxAmountShelf=7;
		int shelvesAmount=totalTeddyBears/maxAmountShelf;

        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int totalPic=480;
		int totalPages=20;
		int albumNeed=totalPic/totalPages;

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int totalCards=94;
		int boxCap=8;
		int boxFilled= totalCards/boxCap;
		int unfilled=totalCards % boxCap;

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int totalBo=210;
		int totalShe=10;
		int shelfC=totalBo/totalShe;

        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double chrisBa=17;
		double planServe=7;
		double eachGet=chrisBa/planServe;

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 12 x 14 rooms?
	    Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
	    */
		double billRate = (12*14)/ 2.15; //rooms per hour
		double jillRate = (12*14) / 1.9; //rooms per hour
		double combinedRate = billRate + jillRate;
		double totalWalls = 5*(14*12);
		double howLong=totalWalls/combinedRate;



	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		String firstName="Grace";
		String middleInit= "B";
		String lastName= "Hopper";
		String fullName= lastName+ ", "+ firstName +" " +middleInit+".";

	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		double distanceTraveledNC=800;
		double distanceCompletedAlready=537;
		double distancePercentageAmount=distanceCompletedAlready/distanceTraveledNC*100;
		int answer = (int) distancePercentageAmount;
	}

}
