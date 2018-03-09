#!/usr/bin/env python3
#Python 3.6.4

import time
import math

current_milli_time = lambda: int(round(time.time() * 1000))

def main():
    """
        $ python3 main.py
            Addition ops: 4167608 9335216.0
            Addition 1000000.0 cycles (miliseconds): 159
            Subtraction ops: 4088216 -7176432.0
            Subtraction 1000000.0 cycles (miliseconds): 167
            Mubtraction ops: 4150634 inf
            Multiplication 1000000.0 cycles (miliseconds): 171
            Division ops: 3062825 0.0
            Division 1000000.0 cycles (miliseconds): 168

        python main.py
            ('Addition ops:', 5672282, 12344564.0)
            Addition 1000000.0 cycles (miliseconds): 108
            ('Subtraction ops:', 5443606, -9887212.0)
            Subtraction 1000000.0 cycles (miliseconds): 114
            ('Mubtraction ops:', 5577323, inf)
            Multiplication 1000000.0 cycles (miliseconds): 110
            ('Division ops:', 5418457, 0.0)    
        
    """

    cycles = additionSecond()
    additionCycles(cycles)

    cycles = subtractionSecond()
    subtractionCycles(cycles)

    cycles = multiplicationSecond()
    multiplicationCycles(cycles)

    cycles = divisionSecond()
    divisionCycles(cycles)

def additionSecond():
    start_time = time.time()
    finish_time = start_time + float(1)
    value = math.pow(10, 6)
    count = 0
    while time.time() <= finish_time:
        value += 2
        count += 1
    print("Addition ops:", count, value)
    return count

def additionCycles(max_cycles):
    start_time = current_milli_time()
    cycles = 0
    if max_cycles >= math.pow(10, 6):
        max_cycles = math.pow(10, 6)
    value = math.pow(10, 6)
    while cycles <= max_cycles:
        value += 2
        cycles += 1
    diff_time = current_milli_time() - start_time       
    print('Addition {0} cycles (miliseconds): {1}'.format(max_cycles, diff_time))    

def subtractionSecond():
    start_time = time.time()
    finish_time = start_time + float(1)
    value = math.pow(10, 6)
    count = 0
    while time.time() <= finish_time:
        value -= 2
        count += 1
    print("Subtraction ops:", count, value)
    return count

def subtractionCycles(max_cycles):
    start_time = current_milli_time()
    cycles = 0
    if max_cycles >= math.pow(10, 6):
        max_cycles = math.pow(10, 6)
    value = math.pow(10, 6)
    while cycles <= max_cycles:
        value -= 2
        cycles += 1
    diff_time = current_milli_time() - start_time       
    print('Subtraction {0} cycles (miliseconds): {1}'.format(max_cycles, diff_time))       

def multiplicationSecond():
    start_time = time.time()
    finish_time = start_time + float(1)
    value = math.pow(10, 6)
    count = 0
    while time.time() <= finish_time:
        value *= 2
        count += 1
    print("Mubtraction ops:", count, value)
    return count

def multiplicationCycles(max_cycles):
    start_time = current_milli_time()
    cycles = 0
    if max_cycles >= math.pow(10, 6):
        max_cycles = math.pow(10, 6)
    value = math.pow(10, 6)
    while cycles <= max_cycles:
        value *= 2
        cycles += 1
    diff_time = current_milli_time() - start_time       
    print('Multiplication {0} cycles (miliseconds): {1}'.format(max_cycles, diff_time))     

def divisionSecond():
    start_time = time.time()
    finish_time = start_time + float(1)
    value = math.pow(10, 6)
    count = 0
    while time.time() <= finish_time:
        value /= 2
        count += 1
    print("Division ops:", count, value)
    return count

def divisionCycles(max_cycles):
    start_time = current_milli_time()
    cycles = 0
    if max_cycles >= math.pow(10, 6):
        max_cycles = math.pow(10, 6)
    value = math.pow(10, 6)
    while cycles <= max_cycles:
        value /= 2
        cycles += 1
    diff_time = current_milli_time() - start_time       
    print('Division {0} cycles (miliseconds): {1}'.format(max_cycles, diff_time))    

if __name__ == '__main__':
    main()