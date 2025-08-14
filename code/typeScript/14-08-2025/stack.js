var Stack = /** @class */ (function () {
    function Stack() {
        this.items = [];
    }
    Stack.prototype.push = function (item) {
        this.items.push(item);
    };
    Stack.prototype.pop = function () {
        return this.items.pop();
    };
    Stack.prototype.peek = function () {
        return this.items[this.items.length - 1];
    };
    return Stack;
}());
var stack = new Stack();
stack.push(10);
stack.push(20);
stack.push(30);
console.log("Peek:", stack.peek());
console.log("Pop:", stack.pop());
console.log("Peek after pop:", stack.peek());
var stringStack = new Stack();
stringStack.push("Hello");
stringStack.push("World");
console.log("Peek:", stringStack.peek());
console.log("Pop:", stringStack.pop());
