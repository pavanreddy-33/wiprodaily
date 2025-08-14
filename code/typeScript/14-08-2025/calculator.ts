class Calculator1 {
  add(a: number, b: number): number {
    return a + b;
  }

  subtract(a: number, b: number): number {
    return a - b;
  }
}


const c = new Calculator1();
console.log("Addition:", c.add(10, 5));  
console.log("Subtraction:", c.subtract(10, 5));