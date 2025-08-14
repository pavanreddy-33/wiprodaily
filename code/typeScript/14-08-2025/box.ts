class Box<T>{
    value: T;

  constructor(value: T) {
    this.value = value;
  }

  getValue(): T {
    return this.value;
  }

}

const num = new Box<number>(33);
console.log(num);

const str = new Box<String>("Pavan");
console.log(str);