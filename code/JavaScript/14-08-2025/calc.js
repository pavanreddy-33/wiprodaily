import { multiply, divide } from './operations.js';

const num1 = 10;
const num2 = 5;

const mulResult = multiply(num1, num2);
const divResult = divide(num1, num2);
const divByZeroResult = divide(num1, 0);

console.log(`Multiply: ${mulResult}`);
console.log(`Divide: ${divResult}`);
console.log(`Divide by zero: ${divByZeroResult}`);
