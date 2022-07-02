chapter6
---
[top]: topOfThePage

ref | fileName | type | shown
--- | --- | --- | ---:
Disp0602 | [ ArrayOfScores.java ]( chapter6/src/ArrayOfScores.java )        | Array | `double[] score = new double[5];`
Disp0603 | [ DifferentEquals.java ]( chapter6/src/DifferentEquals.java )    | Array equal | `boolean equalArrays(int[] a, int[] b)`
Disp0605 | [ GolfScores.java ]( chapter6/src/GolfScores.java )              | partially filled array | `double[] score = new double[MAX_NUM]; int numUsed = 0; numUsed = fillArray(score); showDifference(score, numUsed);`
Disp0605 | [ PartiallyFilledArray.java ]( chapter6/src/PartiallyFilledArray.java ) | Array constructor | `private int maxNumberElements; private double[] a; private int numberUsed;`
Exec0609 | [ Exec0609.java ]( chapter6/src/Exec0609.java )                  | Array | ` double[] a = {1.2, 2.1, 3.3, 2.5, 4.5,7.9, 5.4, 8.7, 9.9, 1.0};`
Disp0606 | [ GolfScoresVersion2.java ]( chapter6/src/GolfScoresVersion2.java )              | Array | `PartiallyFilledArray score = new PartiallyFilledArray(MAX_NUMBER_SCORES); fillArray(score); showDifference(score);`
Exec0615 | [ GolfScoresStaticExercise.java ]( chapter6/src/GolfScoresStaticExercise.java ) | Static | `System.out.println("Enter golf scores:"); fillArray(); showDifference();`
Disp0607 | [ UtilityClass.java ]( chapter6/src/UtilityClass.java )          | int... | `public static int max(int... arg) {`
Disp0608 | [ Utility2.java ]( chapter6/src/Utility2.java )                  | String | `public static String censor(String sentence, String... unwanted) {`
Disp0609 | [ ToyExample.java ]( chapter6/src/ToyExample.java )              | Date[] | ` private Date[] a; `
Disp0611 | [ SelectionSort.java ]( chapter6/src/SelectionSort.java )        | sort | `int indexOfNextSmallest = indexOfSmallest(index, a, numberUsed); interchange(index, indexOfNextSmallest, a);`
Disp0613 | [ EnumDemo.java ]( chapter6/src/EnumDemo.java )                  | Enum | `WorkDay startDay = WorkDay.MONDAY;` `WorkDay[] day = WorkDay.values();` `Flavor favourite = Flavor.valueOf(answer);`
Disp0618 | [ GradeBook.java ]( chapter6/src/GradeBook.java )                | Arrays | `public static void main(String[] args) { GradeBook book = new GradeBook();  book.display(); }`
Proj0601 | [ CourierAgency.java ]( chapter6/src/CourierAgency.java )        | ternary | `withinCity[i] =keyboard.nextBoolean();` `cost= Math.ceil(parcel[i])*2; cost += withinCity[i] ? 20 : 40;`
Proj0602 | [ MemoryGame.java ]( chapter6/src/MemoryGame.java ) |  | ` `
Proj0603 | [ AverageSalary.java ]( chapter6/src/AverageSalary.java )        | objects | `private int[] salary; private int[] otHours; private int[] otPay; private int[] grossSalary; private int ...`
Proj0604 | [ ValueAddedCourse.java ]( chapter6/src/ValueAddedCourse.java )  | partially filled array | `... fillArray()... add(int newElement) ... validateMarks() ... delete(int index) ...`
Proj0605 | [ NumberOfOccurences.java ]( chapter6/src/NumberOfOccurences.java ) |  | `private static void selectionSort(int[] a, int numberUsed) {`
Proj0606 | [ LargestToSmallest.java ]( chapter6/src/LargestToSmallest.java ) | keyboard | `while (keyboard.hasNextInt() && (index < num.length)) { next = keyboard.nextInt();`
Proj0607 | [ Sum20digitIntegers.java ]( chapter6/src/Sum20digitIntegers.java ) | Array | `for (int i = 0; (i < used1) || (i < used2); i++) {` `digit = Character.digit(d.charAt(i), 10); repeat = true;`
Proj0608 | [ BubbleSort.java ]( chapter6/src/BubbleSort.java )              | sort | `for (index = 0; index < numberUsed - 1; index++) { if (a[index] > a[index + 1]) { interchange(index, index + 1, a);}`
Proj0609 | [ PartiallyFilledArray.java ]( chapter6/src/PartiallyFilledArray.java ) | Array | `increaseCapacity(maxNumberElements * 2);`
Proj0610 | [ GridOfStar.java ]( chapter6/src/GridOfStar.java )              | method | `GridOfStar.start();`
Proj0611 | [ PassengersSeats.java ]( chapter6/src/PassengersSeats.java )    | while | `innerloop: while (toContNext) { ...; if (!pickSeat(pick)) { break innerloop; } else if (...`
Proj0612 | [ SimpleTrivia.java ]( chapter6/src/SimpleTrivia.java ) |  | ` `
Proj0613 | [ Trivia.java ]( chapter6/src/Trivia.java )                      | Object | `private Trivia[] arr = new Trivia[MAX_SIZE];` `private Trivia(String question, String answer, int point) {`
Proj0614 | [ PinAuthenticate.java ]( chapter6/src/PinAuthenticate.java )    | char | `ch = userKeyIn.charAt(i); userDigit = Integer.parseInt(ch + ""); if (!comapareAssignIndex(pinDigit, userDigit)) {`
Proj0615 | [ PizzaOrder.java ]( chapter6/src/PizzaOrder.java ) |  | ` `
Proj | [ main.java ]( chapter6/src/main.java ) |  | ` `
Proj | [ main.java ]( chapter6/src/main.java ) |  | ` `

<!--- MacBook GMax has failed to Git push for two days, due to authentication. 
Checked on email axxxx43525@g for details. 
For this, will email these java files to desktop for git push. --->

[:top: Top](#top)

---
