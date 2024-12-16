class TaskNine{
	public static void main(String... args){  

int number = 0;
int count = 1;
int number1 = 1;
int number2 = 1;

while (count <= 5){
number1 *= 4;
number += number1;
	
		count++;
	
}


 count = 1; 

while (count <= 5) { 
number2 *= 8;
number += number2;		
	count++;	
}

	int result = number * number;
System.out.println(result);



        }


}