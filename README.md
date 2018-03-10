# Тестирование скрости выполнения арифметических операций у различных языков программирования

### Скросить выполения сложения, вычитания, умножения и деления при асимптотической сложности O(N)

1. На C:

    ``` bash
        $ gcc --version
            gcc (GCC) 7.3.1 20180130 (Red Hat 7.3.1-2)
            Copyright (C) 2017 Free Software Foundation, Inc.
            This is free software; see the source for copying conditions.  There is NO
            warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
        $ gcc main.c -o main && ./main
            Addition ops: 452576811 906153622
            Addition 1000000 cycles (milliseconds): 2.453000
            Subtraction ops: 521797940 -1042595880
            Subtraction 1000000 cycles (milliseconds): 2.613000
            Multiplication ops: 477303302 inf
            Multiplication 1000000 cycles (milliseconds): 3.719000
            Division ops: 314385786 0.000000
            Division 1000000 cycles (milliseconds): 7.333000
    ```
> Например: Addition ops: [число циклов за одну секунду] [полученое значение]
2. На Go:

    ``` bash
        $ go version
            go version go1.10 linux/amd64
        $ go run main.go
            Addition ops: 18237288 37474576
            Addition 1000000 cycles (milliseconds): 0.522743
            Subtraction ops: 28181471 -55362942
            Subtraction 1000000 cycles (milliseconds): 0.534796
            Multiplication ops: 28580481 +Inf
            Multiplication 1000000 cycles (milliseconds): 0.470221
            Division ops: 28209822 0
            Division 1000000 cycles (milliseconds): 0.468782
    ```
3. На NodeJS:

    ``` bash
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
    ```

4. На PHP:

    ``` bash
        $ php --version
            PHP 7.1.14 (cli) (built: Jan 30 2018 19:05:27) ( NTS )
            Copyright (c) 1997-2018 The PHP Group
            Zend Engine v3.1.0, Copyright (c) 1998-2018 Zend Technologies
        $ php main.php
            Addition ops:28622779 58245558
            Addition 1000000 cycles (milliseconds): 29.556035995483
            Subtraction ops:56074025 -111148050
            Subtraction 1000000 cycles (milliseconds): 31.360149383545
            Multiplication ops:56888320 INF
            Multiplication 1000000 cycles (milliseconds): 27.434110641479
            Division ops:55865081 0
            Division 1000000 cycles (milliseconds): 29.772043228149
    ```
> PHP побеждает NodeJS на операциях когда мы постоянно проверяем время 
``` php
    while (time() <= $finishTimeStamp) {}
``` 
> но проигрывает когда проверка происходит по счетчику
``` php
    while ($cycles <= $maxCycles) { $cycles++; }
```

5. На Python:

``` bash
    $ python --version
        Python 2.7.14
    $ python3 main.py
        ('Addition ops:', 5672282, 12344564.0)
        Addition 1000000.0 cycles (milliseconds): 108
        ('Subtraction ops:', 5443606, -9887212.0)
        Subtraction 1000000.0 cycles (milliseconds): 114
        ('Mubtraction ops:', 5577323, inf)
        Multiplication 1000000.0 cycles (milliseconds): 110
        ('Division ops:', 5418457, 0.0)
        Division 1000000.0 cycles (milliseconds): 131
```
> Сильно проигрывает по сравнению с остальными

6. На Python3:

``` bash
    $ python3 --version
        Python 3.6.4
    $ python3 main.py
        Addition ops: 4167608 9335216.0
        Addition 1000000.0 cycles (milliseconds): 159
        Subtraction ops: 4088216 -7176432.0
        Subtraction 1000000.0 cycles (milliseconds): 167
        Mubtraction ops: 4150634 inf
        Multiplication 1000000.0 cycles (milliseconds): 171
        Division ops: 3062825 0.0
        Division 1000000.0 cycles (milliseconds): 168
```
> Python3 проигрывет даже второму питону

#### Заметка
> Не ручаюсь за верность проводимого тестирования, т.к. оно тривиально и наверняка я что-то делаю не так, тем не менее интересно замечать столь отличающиеся результаты.