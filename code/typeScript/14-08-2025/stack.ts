class Stack<T>{
    items:T[]=[];

    push(item:T):void{
        this.items.push(item);
    }

    pop():T|undefined {
        return this.items.pop();
    }

    peek():T|undefined{
        return this.items[this.items.length-1];
    }
}

const stack = new Stack<number>();
stack.push(10);
stack.push(20);
stack.push(30);

console.log("Peek:", stack.peek()); 
console.log("Pop:", stack.pop());   
console.log("Peek after pop:", stack.peek()); 

const stringStack = new Stack<string>();
stringStack.push("Hello");
stringStack.push("World");

console.log("Peek:", stringStack.peek()); 
console.log("Pop:", stringStack.pop());