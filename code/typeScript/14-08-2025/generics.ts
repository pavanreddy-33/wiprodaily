// function printData<T> (data: T): void {
//     console.log(data);
// }
// printData<string>("Hello, World!");
// printData<number>(42);
 
 
class  Demo <T> {
   
    private value: T;
 
    constructor(value: T) {
        this.value = value;
    }
 
    printValue(): void {
        console.log(this.value);  
   
    }
             
    printData(data: T): void {
        console.log(data);
    }
}
 
let demoString1:Demo<string> = new Demo<string>("Hello, World!");
demoString1.printValue();
demoString1.printData("This is a string data");
 