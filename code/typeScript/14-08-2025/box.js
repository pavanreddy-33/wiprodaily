var Box = /** @class */ (function () {
    function Box(value) {
        this.value = value;
    }
    Box.prototype.getValue = function () {
        return this.value;
    };
    return Box;
}());
var num = new Box(33);
console.log(num);
var str = new Box("Pavan");
console.log(str);
