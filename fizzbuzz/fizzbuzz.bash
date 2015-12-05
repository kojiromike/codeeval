#!/usr/bin/env bash

fizzbuzz() {
    while read X Y N; do
        row=()
        for ((i=1; i<=N; i++)); do
            result=$i
            if ((i % X == 0 && i % Y == 0)); then
                result=FB
            elif ((i % X == 0)); then
                result=F
            elif ((i % Y == 0)); then
                result=B
            fi
            row+=($result)
        done
        echo "${row[@]}"
    done
}

fizzbuzz_filerunner() {
    fizzbuzz < "$1"
}

fizzbuzz_tests() {
    local test_script
    test_script() {
        while true; do
            (( X=(RANDOM % 20) + 1 ))
            (( Y=(RANDOM % 20) + 1 ))
            (( N=(RANDOM % (100 - 21)) + 21 ))
            echo "$X $Y $N"
        done | head -n 20
    }
    fizzbuzz_filerunner <(test_script)
}

if [[ $1 ]]; then
    fizzbuzz_filerunner "$1"
fi
