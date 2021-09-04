function getCurrentDateTime()
{
    const date = new Date();
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hours = date.getHours();
    const minutes = date.getMinutes();
    const seconds = date.getSeconds();
    return year + "-" + formatZero(month) + "-" + formatZero(day) + " " + formatZero(hours) + ":" + formatZero(minutes) + ":" + formatZero(seconds);
}

function getCurrentDate()
{
    const date = new Date();
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    return year + "-" + formatZero(month) + "-" + formatZero(day);
}


function formatZero(n) {
    if (n >= 0 && n <= 9) {
        return "0" + n;
    } else {
        return n;
    }
}