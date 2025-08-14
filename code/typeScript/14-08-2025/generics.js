// function printData<T> (data: T): void {
//     console.log(data);
// }
// printData<string>("Hello, World!");
// printData<number>(42);
var Demo = /** @class */ (function () {
    function Demo(value) {
        this.value = value;
    }
    Demo.prototype.printValue = function () {
        console.log(this.value);
    };
    Demo.prototype.printData = function (data) {
        console.log(data);
    };
    return Demo;
}());
var demoString1 = new Demo("Hello, World!");
demoString1.printValue();
demoString1.printData("This is a string data");
