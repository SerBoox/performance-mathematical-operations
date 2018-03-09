package main

import (
	"fmt"
	"math"
	"time"
)

func main() {
	//go version go1.10 linux/amd64
	/*
		$ go run main.go
		Addition ops: 18237288 37474576
		Addition 1000000 cycles (miliseconds): 0.522743
		Subtraction ops: 28181471 -55362942
		Subtraction 1000000 cycles (miliseconds): 0.534796
		Multiplication ops: 28580481 +Inf
		Multiplication 1000000 cycles (miliseconds): 0.470221
		Division ops: 28209822 0
		Division 1000000 cycles (miliseconds): 0.468782
	*/
	cycles := additionSecond()
	additionCycles(cycles)
	cycles = subtractionSecond()
	subtractionCycles(cycles)
	cycles = multiplicationSecond()
	multiplicationCycles(cycles)
	cycles = divisionSecond()
	divisionCycles(cycles)
}

func additionSecond() (count int64) {
	startTime := time.Now()
	finishTime := startTime.Add(1 * time.Second)
	value := int64(math.Pow10(6))
	for time.Now().Unix() <= finishTime.Unix() {
		value += 2
		count++
	}
	fmt.Println("Addition ops:", count, value)
	return
}

func additionCycles(maxCycles int64) {
	startTime := time.Now().UnixNano()
	cycles := int64(0)
	if maxCycles >= int64(math.Pow10(6)) {
		maxCycles = int64(math.Pow10(10))
	}
	value := int64(math.Pow10(6))
	for cycles <= maxCycles {
		value += 2
		cycles++
	}
	diffTime := float64(time.Now().UnixNano()-startTime) / math.Pow10(6)
	fmt.Printf("Addition %d cycles (miliseconds): %f\n", maxCycles, diffTime)
}

func subtractionSecond() (count int64) {
	startTime := time.Now()
	finishTime := startTime.Add(1 * time.Second)
	value := int64(math.Pow10(6))
	for time.Now().Unix() <= finishTime.Unix() {
		value -= 2
		count++
	}
	fmt.Println("Subtraction ops:", count, value)
	return
}

func subtractionCycles(maxCycles int64) {
	startTime := time.Now().UnixNano()
	cycles := int64(0)
	if maxCycles >= int64(math.Pow10(6)) {
		maxCycles = int64(math.Pow10(6))
	}
	value := int64(math.Pow10(6))
	for cycles <= maxCycles {
		value -= 2
		cycles++
	}
	diffTime := float64(time.Now().UnixNano()-startTime) / math.Pow10(6)
	fmt.Printf("Subtraction %d cycles (miliseconds): %f\n", maxCycles, diffTime)
}

func multiplicationSecond() (count int64) {
	startTime := time.Now()
	finishTime := startTime.Add(1 * time.Second)
	value := math.Pow10(6)
	for time.Now().Unix() <= finishTime.Unix() {
		value *= 2
		count++
	}
	fmt.Println("Multiplication ops:", count, value)
	return
}

func multiplicationCycles(maxCycles int64) {
	startTime := time.Now().UnixNano()
	cycles := int64(0)
	if maxCycles >= int64(math.Pow10(6)) {
		maxCycles = int64(math.Pow10(6))
	}
	value := math.Pow10(6)
	for cycles <= maxCycles {
		value *= 2
		cycles++
	}
	diffTime := float64(time.Now().UnixNano()-startTime) / math.Pow10(6)
	fmt.Printf("Multiplication %d cycles (miliseconds): %f\n", maxCycles, diffTime)
}

func divisionSecond() (count int64) {
	startTime := time.Now()
	finishTime := startTime.Add(1 * time.Second)
	value := math.Pow10(6)
	for time.Now().Unix() <= finishTime.Unix() {
		value = value / 2
		count++
	}
	fmt.Println("Division ops:", count, value)
	return
}

func divisionCycles(maxCycles int64) {
	startTime := time.Now().UnixNano()
	cycles := int64(0)
	if maxCycles >= int64(math.Pow10(6)) {
		maxCycles = int64(math.Pow10(6))
	}
	value := math.Pow10(6)
	for cycles <= maxCycles {
		value /= 2
		cycles++
	}
	diffTime := float64(time.Now().UnixNano()-startTime) / math.Pow10(6)
	fmt.Printf("Division %d cycles (miliseconds): %f\n", maxCycles, diffTime)
}
