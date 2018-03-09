# Тестирование скрости выполнения арифметических операций

### Скросить выполения сложения, вычитания, умножения и деления

1. На Go:

    ``` bash
        $ go version
            go version go1.10 linux/amd64
        $ go run main.go
            Addition ops: 18237288 37474576
            Addition 1000000 cycles (miliseconds): 0.522743
            Subtraction ops: 28181471 -55362942
            Subtraction 1000000 cycles (miliseconds): 0.534796
            Multiplication ops: 28580481 +Inf
            Multiplication 1000000 cycles (miliseconds): 0.470221
            Division ops: 28209822 0
            Division 1000000 cycles (miliseconds): 0.468782
    ```
> Например: Addition ops: [число циклов за одну секунду] [полученое значение]
2. На PHP:

    ``` bash
        $ php --version
            PHP 7.1.14 (cli) (built: Jan 30 2018 19:05:27) ( NTS )
            Copyright (c) 1997-2018 The PHP Group
            Zend Engine v3.1.0, Copyright (c) 1998-2018 Zend Technologies
        $ php main.php
            Addition ops:28622779 58245558
            Addition 1000000 cycles (miliseconds): 29.556035995483
            Subtraction ops:56074025 -111148050
            Subtraction 1000000 cycles (miliseconds): 31.360149383545
            Multiplication ops:56888320 INF
            Multiplication 1000000 cycles (miliseconds): 27.434110641479
            Division ops:55865081 0
            Division 1000000 cycles (miliseconds): 29.772043228149
    ```
> PHP побеждает на операциях когда мы постоянно проверяем время 
``` php
    while (time() <= $finishTimeStamp) {}
``` 
> но проигрывает когда проверка происходит по счетчику
``` php
    while ($cycles <= $maxCycles) { $cycles++; }
```

3. На Python:

``` bash
    $ python --version
        Python 2.7.14
    $ python3 main.py
        ('Addition ops:', 5672282, 12344564.0)
        Addition 1000000.0 cycles (miliseconds): 108
        ('Subtraction ops:', 5443606, -9887212.0)
        Subtraction 1000000.0 cycles (miliseconds): 114
        ('Mubtraction ops:', 5577323, inf)
        Multiplication 1000000.0 cycles (miliseconds): 110
        ('Division ops:', 5418457, 0.0)
```
> Сильно проигрывает по сравнению с остальными

4. На Python3:

``` bash
    $ python3 --version
        Python 3.6.4
    $ python3 main.py
        Addition ops: 4167608 9335216.0
        Addition 1000000.0 cycles (miliseconds): 159
        Subtraction ops: 4088216 -7176432.0
        Subtraction 1000000.0 cycles (miliseconds): 167
        Mubtraction ops: 4150634 inf
        Multiplication 1000000.0 cycles (miliseconds): 171
        Division ops: 3062825 0.0
        Division 1000000.0 cycles (miliseconds): 168
```
> Python3 проигрывет даже второму питону

#### Заметка
> Не ручаюсь за верность проводимого тестирования, т.к. оно тривиально и наверняка я что-то делаю не так, тем не менее интересно замечать столь отличающиеся результаты.