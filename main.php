<?php
/**
 * Performance operators Doc Comment
 * PHP version 7.1.14
 *
 * @category Function
 * @package  Perfomance
 * @author   Sergey <serboox@gmail.com>
 * @license  http://www.gnu.org/copyleft/gpl.html GNU General Public License
 * @link     https://github.com/SerBoox
 */

/**
 * Undocumented function
 *
 * @return void
 */
function main() 
{   
    /*
        $ php main.php
        Addition ops:26854188 54708376
        Subtraction ops:52851551 -104703102
        Multiplication ops:53683114 INF
        Division ops:52441457 0
    */
    $cycles = additionSecond();
    additionCycles($cycles);
    $cycles = subtractionSecond();
    subtractionCycles($cycles);
    $cycles = multiplicationSecond();
    multiplicationCycles($cycles);
    $cycles = divisionSecond();
    divisionCycles($cycles);
}

main();

/**
 * Undocumented function
 *
 * @return integer
 */
function additionSecond() : int
{
    $startTime = new DateTime();
    $finishTime = clone $startTime;
    $finishTime->modify('+1 second');
    $finishTimeStamp = strtotime($finishTime->format('Y-m-d H:i:s'));
    $value = pow(10, 6);
    $count = 0;
    while (time() <= $finishTimeStamp) {
        $value += 2;
        $count++;
    }
    print_r("Addition ops:{$count} {$value}\n");
    return $count;
}

/**
 * Undocumented function
 *
 * @param integer $maxCycles
 * @return void
 */
function additionCycles(int $maxCycles) 
{
    $startTime = microtime(true);
    $cycles = 0;
    if ($maxCycles >= pow(10, 6)) {
        $maxCycles = pow(10, 6);
    }
    $value = pow(10, 6);
    while ($cycles <= $maxCycles) {
        $value += 2;
        $cycles++;
    }
    $diffTime = (microtime(true) - $startTime) * pow(10, 3);
    print_r("Addition {$maxCycles} cycles (miliseconds): {$diffTime}\n");
}

/**
 * Undocumented function
 *
 * @return int
 */
function subtractionSecond() : int
{
    $startTime = new DateTime();
    $finishTime = clone $startTime;
    $finishTime->modify('+1 second');
    $finishTimeStamp = strtotime($finishTime->format('Y-m-d H:i:s'));
    $value = pow(10, 6);
    $count = 0;
    while (time() <= $finishTimeStamp) {
        $value -= 2;
        $count++;
    }
    print_r("Subtraction ops:{$count} {$value}\n");
    return $count;
}

/**
 * Undocumented function
 *
 * @return void
 */
function subtractionCycles($maxCycles) 
{
    $startTime = microtime(true);
    $cycles = 0;
    if ($maxCycles >= pow(10, 6)) {
        $maxCycles = pow(10, 6);
    }
    $value = pow(10, 6);
    while ($cycles <= $maxCycles) {
        $value -= 2;
        $cycles++;
    }
    $diffTime = (microtime(true) - $startTime) * pow(10, 3);
    print_r("Subtraction {$maxCycles} cycles (miliseconds): {$diffTime}\n");
}

/**
 * Undocumented function
 *
 * @return void
 */
function multiplicationSecond() : int
{
    $startTime = new DateTime();
    $finishTime = clone $startTime;
    $finishTime->modify('+1 second');
    $finishTimeStamp = strtotime($finishTime->format('Y-m-d H:i:s'));
    $value = pow(10, 6);
    $count = 0;
    while (time() <= $finishTimeStamp) {
        $value *= 2;
        $count++;
    }
    print_r("Multiplication ops:{$count} {$value}\n");
    return $count;
}

/**
 * Undocumented function
 *
 * @param [int] $maxCycles
 * @return void
 */
function multiplicationCycles($maxCycles) 
{
    $startTime = microtime(true);
    $cycles = 0;
    if ($maxCycles >= pow(10, 6)) {
        $maxCycles = pow(10, 6);
    }
    $value = pow(10, 6);
    while ($cycles <= $maxCycles) {
        $value *= 2;
        $cycles++;
    }
    $diffTime = (microtime(true) - $startTime) * pow(10, 3);
    print_r("Multiplication {$maxCycles} cycles (miliseconds): {$diffTime}\n");
}

/**
 * Undocumented function
 *
 * @return int
 */
function divisionSecond() : int
{
    $startTime = new DateTime();
    $finishTime = clone $startTime;
    $finishTime->modify('+1 second');
    $finishTimeStamp = strtotime($finishTime->format('Y-m-d H:i:s'));
    $value = pow(10, 6);
    $count = 0;
    while (time() <= $finishTimeStamp) {
        $value /= 2;
        $count++;
    }
    print_r("Division ops:{$count} {$value}\n");
    return $count;
}

/**
 * Undocumented function
 *
 * @param int $maxCycles
 * @return void
 */
function divisionCycles(int $maxCycles) 
{
    $startTime = microtime(true);
    $cycles = 0;
    if ($maxCycles >= pow(10, 6)) {
        $maxCycles = pow(10, 6);
    }
    $value = pow(10, 6);
    while ($cycles <= $maxCycles) {
        $value /= 2;
        $cycles++;
    }
    $diffTime = (microtime(true) - $startTime) * pow(10, 3);
    print_r("Division {$maxCycles} cycles (miliseconds): {$diffTime}\n");
}