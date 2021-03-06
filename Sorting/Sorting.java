//  Description: sort a queue

import java.util.LinkedList; //LinkedList will be used as a queue

public class Sorting		//Constructor class for Sorting
 {
   private LinkedList mainQueue;
   private LinkedList[] subQueues;
   private final int SIZE = 10;
   private int maxDigits; //maximum number of digits

   //The constructor instantiates the mainQueue using the LinkedList,
   //subQueue array as an array of LinkedList using SIZE(10),
   //and initializes maxDigits = 0;
   public Sorting()
    {
		mainQueue = new LinkedList();
		subQueues = new LinkedList[SIZE];
		maxDigits = 0;

		for(int i = 0; i <10; i++)	//make 10 subQueues
		{
			subQueues[i] = new LinkedList();
		}
     }

   //The addToMainQueue method checks the number of digits
   //of the positive integer parameter "num", and
   //if it is larger than the current value in "maxDigits",
   //updates its value to the number of digits of "num".
   //The method also enqueues "num" to the main-queue.
   public void addToMainQueue(Integer num)
    {

		String x = num.toString();	//get value as a String

		int numCheck = x.length();	//fin length (num of digits)

		if(numCheck > maxDigits)	//check to update max
		{
			maxDigits = numCheck;
		}

		mainQueue.addLast(num);	//add to end of queue

    }


   //The listMaintQueue method returns a string containing
   //the content of the main-queue
   public String listMainQueue()
    {
       return ("mainQueue = " + listQueue(mainQueue)+"\n");
     }


   //The listSubQueues method returns a string containing
   //the content of the sub-queues
   public String listSubQueues()
    {
        String result = "";

        for (int i=0; i<SIZE; i++)
         {
             result += "subQueue[" + i + "]:";
             result += listQueue(subQueues[i]);
             result += "\n";
         }
         return result;
     }


   //The listQueue method returns a string containing
   //the content of the parameter queue
   public String listQueue(LinkedList queue)
    {
        LinkedList temp = new LinkedList();
        String result = "{ ";

        //Removing each element from the queue
        //and appending to the string to be returned
        while (!queue.isEmpty())
         {
            Object removed = queue.remove();
            result += removed + " ";
            temp.offer(removed);
         }
        result += "}\n";

        //Copying the temporary queue back to the
        //original queue
        while (!temp.isEmpty())
         {
            Object removed2 = temp.remove();
            queue.offer(removed2);
         }
        return result;
    }


   //The sortNumbers method sorts numbers in the main queue.
   public void sortNumbers()
    {
		for(int i = 0; i < maxDigits; i++)	//run for every digit of the largest value
		{
			while(!mainQueue.isEmpty()) 	//run until main queue is empty for current digit
			{
				Integer x = (Integer)mainQueue.removeFirst();
				int val = x.intValue();
				int digit = (int)(val / Math.pow(10, i)) % 10; //check specified digit by dividing by ten then modulo ten to get value

				subQueues[digit].addLast(val); //add to subqueue for the digit
			}

			System.out.print(listSubQueues());

			for (int j = 0; j < SIZE; j++)	// repopulate main
			{
				while(!subQueues[j].isEmpty())
				{
					mainQueue.addLast(subQueues[j].removeFirst());
				}
			}

			System.out.print(listMainQueue());
		}
    }
 }
