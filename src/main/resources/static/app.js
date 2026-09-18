const calendarModeButton =
    document.getElementById("calendarModeButton");

const dayModeButton =
    document.getElementById("dayModeButton");

const calendarSection =
    document.getElementById("calendarSection");

const daySection =
    document.getElementById("daySection");

const calendarButton =
    document.getElementById("calendarButton");

const dayButton =
    document.getElementById("dayButton");

const yearInput =
    document.getElementById("yearInput");

const dayInput =
    document.getElementById("dayInput");

const monthInput =
    document.getElementById("monthInput");

const dateYearInput =
    document.getElementById("dateYearInput");

const calendarResult =
    document.getElementById("calendarResult");

const dayResult =
    document.getElementById("dayResult");


calendarModeButton.addEventListener(
    "click",
    () => {

        calendarSection.classList.remove("hidden");
        daySection.classList.add("hidden");

    }
);


dayModeButton.addEventListener(
    "click",
    () => {

        daySection.classList.remove("hidden");
        calendarSection.classList.add("hidden");

    }
);


calendarButton.addEventListener(
    "click",
    async () => {

        const year = yearInput.value;

        if (!year) {

            calendarResult.innerHTML =
                `<p class="error">Введите год</p>`;

            return;
        }

        try {

            const response =
                await fetch(
                    `/api/calendar/${year}`
                );

            const data =
                await response.json();

            if (!response.ok) {
                throw new Error(data.message);
            }

            renderCalendar(data);

        } catch (error) {

            calendarResult.innerHTML =
                `<p class="error">Ошибка: ${error.message}</p>`;

        }
    }
);


dayButton.addEventListener(
    "click",
    async () => {

        const day = dayInput.value;
        const month = monthInput.value;
        const year = dateYearInput.value;

        if (!day || !month || !year) {

            dayResult.innerHTML =
                `<p class="error">Заполните все поля</p>`;

            return;
        }

        try {

            const response =
                await fetch(
                    `/api/calendar/day-of-week` +
                    `?day=${day}` +
                    `&month=${month}` +
                    `&year=${year}`
                );

            const data =
                await response.json();

            if (!response.ok) {
                throw new Error(data.message);
            }

            dayResult.innerHTML = `
                <div class="day-result">
                    Дате ${data.date}
                    соответствует день недели:
                    <strong>${data.dayOfWeek}</strong>
                </div>
            `;

        } catch (error) {

            dayResult.innerHTML =
                `<p class="error">Ошибка: ${error.message}</p>`;

        }
    }
);

function renderCalendar(data) {

    let html = `
        <h2 class='result-title'>Календарь ${data.year} года</h2>

        <div class="calendar-year">
    `;

    data.months.forEach(month => {

        html += `
            <div class="month">

                <h3>${month.monthName}</h3>

                <table>

                    <thead>
                        <tr>
                            <th>Пн</th>
                            <th>Вт</th>
                            <th>Ср</th>
                            <th>Чт</th>
                            <th>Пт</th>
                            <th>Сб</th>
                            <th>Вс</th>
                        </tr>
                    </thead>

                <tbody>
        `;

        month.daysByWeeks.forEach(week => {

            html += "<tr>";

            week.forEach(day => {

                html += `
                    <td>${day}</td>
                `;

            });

            html += "</tr>";

        });

        html += `
                    </tbody>

                </table>

            </div>
        `;

    });

    html += `
        </div>
    `;

    calendarResult.innerHTML = html;
}