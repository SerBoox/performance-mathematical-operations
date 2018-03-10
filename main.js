

class Test {

  constructor() {

    /*
        $ node --version
            v8.10.0
        $ node main.js
            Addition ops: 7094927 15189854
            Addition 1000000 cycles (milliseconds): 4
            Subtraction ops: 7041159 -13082318
            Subtraction 1000000 cycles (milliseconds): 3
            Multiplication ops: 4857229 Infinity
            Multiplication 1000000 cycles (milliseconds): 3
            Division ops: 4845301 0
            Division 1000000 cycles (milliseconds): 4
    */

    let cycles = this.additionSecond()
    this.additionCycles(cycles)
    cycles = this.subtractionSecond()
    this.subtractionCycles(cycles)
    cycles = this.multiplicationSecond()
    this.multiplicationCycles(cycles)
    cycles = this.divisionSecond()
    this.divisionCycles(cycles)
  }

  additionSecond() {
    const startTime = new Date()
    let finishTime = new Date(startTime.getTime() + 1000),
        value = Math.pow(10, 6),
        count = 0;
    
    while (new Date().getTime() <= finishTime.getTime()) {
        value += 2
        count++
    }
    
    console.log('Addition ops: ' + count + ' ' + value)
    return count
  }

  additionCycles(maxCycles) {
    const startTime = new Date()
    let value = Math.pow(10, 6),
        cycles = 0;
    if (maxCycles >= Math.pow(10, 6)) {
        maxCycles = Math.pow(10, 6)
    }
    while (cycles <= maxCycles) {
        value += 2
        cycles++
    }
    let diffTime = (new Date().getTime() - startTime.getTime())
    console.log('Addition ' + maxCycles +' cycles (milliseconds): ' + diffTime)
  }

  subtractionSecond() {
    const startTime = new Date()
    let finishTime = new Date(startTime.getTime() + 1000),
        value = Math.pow(10, 6),
        count = 0;
    
    while (new Date().getTime() <= finishTime.getTime()) {
        value -= 2
        count++
    }
    
    console.log('Subtraction ops: ' + count + ' ' + value)
    return count
  }

  subtractionCycles(maxCycles) {
    const startTime = new Date()
    let value = Math.pow(10, 6),
        cycles = 0;
    if (maxCycles >= Math.pow(10, 6)) {
        maxCycles = Math.pow(10, 6)
    }
    while (cycles <= maxCycles) {
        value -= 2
        cycles++
    }
    let diffTime = (new Date().getTime() - startTime.getTime())
    console.log('Subtraction ' + maxCycles +' cycles (milliseconds): ' + diffTime)
  }

  multiplicationSecond() {
    const startTime = new Date()
    let finishTime = new Date(startTime.getTime() + 1000),
        value = Math.pow(10, 6),
        count = 0;
    
    while (new Date().getTime() <= finishTime.getTime()) {
        value *= 2
        count++
    }
    
    console.log('Multiplication ops: ' + count + ' ' + value)
    return count
  }

  multiplicationCycles(maxCycles) {
    const startTime = new Date()
    let value = Math.pow(10, 6),
        cycles = 0;
    if (maxCycles >= Math.pow(10, 6)) {
        maxCycles = Math.pow(10, 6)
    }
    while (cycles <= maxCycles) {
        value *= 2
        cycles++
    }
    let diffTime = (new Date().getTime() - startTime.getTime())
    console.log('Multiplication ' + maxCycles +' cycles (milliseconds): ' + diffTime)
  }

  divisionSecond() {
    const startTime = new Date()
    let finishTime = new Date(startTime.getTime() + 1000),
        value = Math.pow(10, 6),
        count = 0;
    
    while (new Date().getTime() <= finishTime.getTime()) {
        value /= 2
        count++
    }
    
    console.log('Division ops: ' + count + ' ' + value)
    return count
  }

  divisionCycles(maxCycles) {
    const startTime = new Date()
    let value = Math.pow(10, 6),
        cycles = 0;
    if (maxCycles >= Math.pow(10, 6)) {
        maxCycles = Math.pow(10, 6)
    }
    while (cycles <= maxCycles) {
        value /= 2
        cycles++
    }
    let diffTime = (new Date().getTime() - startTime.getTime())
    console.log('Division ' + maxCycles +' cycles (milliseconds): ' + diffTime)
  }

}

new Test()