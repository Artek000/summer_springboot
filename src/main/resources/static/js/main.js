const tovarListTemplate = '<div v-for="tovar in tovars" class="col tovar-list-item">\n' +
    '            <div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-4 shadow-lg">\n' +
    '                <div class="d-flex flex-column h-100 p-5 pb-3 text-white text-shadow-1">\n' +
    '                    <h2 class="m-auto pb-5 fw-bold">{{tovar.name}}</h2>\n' +
    '                    <ul class="d-flex list-unstyled mt-auto">\n' +
    '                        <li class="d-flex me-auto">\n' +
    '                            <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>\n' +
    '                            <small>{{tovar.price}} руб.</small>\n' +
    '                        </li>\n' +
    '                        <li class="d-flex align-items-center me-auto">\n' +
    '                            <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#geo-fill"></use></svg>\n' +
    '                            <small class="fw-semibold">{{tovar.category}}</small>\n' +
    '                        </li>\n' +
    '                        <li class="d-flex align-items-center me-auto">\n' +
    '                            <svg class="bi me-2" width="1em" height="1em"><use xlink:href="#calendar3"></use></svg>\n' +
    '                            <small>{{tovar.ostatok}} шт.</small>\n' +
    '                        </li>\n' +
    '                    </ul>\n' +
    '                </div>\n' +
    '            </div>\n' +
    '        </div>';

const TovarComponent = {
    template: 'template-for-tovar',
    props: {
        name: {type: String, required: true},
        category: {type: String, required: true},
        price: {type: Number},
        ostatok: {type: Number},
        dostavka_price: {type: Number},
        sale: {type: Number}
    }
}

const TovarListComponent = {
    components: {tovar: TovarComponent},
    template: tovarListTemplate,
    created: function () {
        fetch("http://localhost:8080/tovars")
            .then(response => response.json())
            .then(data => data.forEach(tovar => this.tovars.push(tovar)))
    },
    data() {
        return {
            tovars: []
            // tovars: [
            //     {name: "Moloko", category: "Drink", price: "69", ostatok: "850", dostavka_price: "35", sale: "20"},
            //     {name: "Banan", category: "Food", price: "87", ostatok: "430", dostavka_price: "6", sale: "5"},
            //     {name: "CocaCola", category: "Drink", price: "88", ostatok: "1850", dostavka_price: "25", sale: "15"}
            // ]
        }
    }
}

const app = Vue.createApp({
    components: {
        'tovar-list': TovarListComponent
    }

});
app.mount("#app");