export default function throttle(fn, delay) {
    let timer
    return function () {
        if (timer) {
            return
        }
        timer = setTimeout(() => {
            fn()
            timer = null
        }, delay)
    }
}