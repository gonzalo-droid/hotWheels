package com.gondroid.wheelsteam.presentation.model

data class ItemCar(
    var name: String,
    var description: String,
    var image: String,
    var code: String,
    var category: Category
)

val itemCars = listOf(
    ItemCar(
        name = "Ferrari F40",
        description = "Un clásico icónico de Ferrari, conocido por su diseño y velocidad.",
        image = "https://tse4.mm.bing.net/th?id=OIP.nEF3PSw78ppYbkGpjBcYQAHaFj&pid=Api",
        code = "HW5001",
        category = Category("Superdeportivos")
    ),
    ItemCar(
        name = "Lamborghini Aventador",
        description = "Un superdeportivo moderno con un motor V12 impresionante.",
        image = "https://tse4.mm.bing.net/th?id=OIP.JugBMBp7ummagJNe8rvC0AHaD4&pid=Api",
        code = "HW5002",
        category = Category("Superdeportivos")
    ),
    ItemCar(
        name = "Bugatti Chiron",
        description = "Uno de los autos más rápidos del mundo con un diseño elegante.",
        image = "https://tse1.mm.bing.net/th?id=OIP.jpQeux3FySbvjf9543O_TQEsCo&pid=Api",
        code = "HW5003",
        category = Category("Hiperautos")
    ),
    ItemCar(
        name = "McLaren P1",
        description = "Un híbrido hiperdeportivo conocido por su avanzada tecnología.",
        image = "https://tse3.mm.bing.net/th?id=OIP.QW5jEOzXaNUAlSOL1lUnlgHaFj&pid=Api",
        code = "HW5004",
        category = Category("Hiperautos")
    ),
    ItemCar(
        name = "Porsche 911 Turbo S",
        description = "Un ícono de Porsche que combina lujo y rendimiento.",
        image = "https://tse4.mm.bing.net/th?id=OIP.ulsbjkR48FW1CvUkS5KE9QHaEK&pid=Api",
        code = "HW5005",
        category = Category("Deportivos de lujo")
    ),
    ItemCar(
        name = "Koenigsegg Jesko",
        description = "Un hiperdeportivo sueco diseñado para romper récords de velocidad.",
        image = "https://tse1.mm.bing.net/th?id=OIP.hztvk8LAdKKWOr1EL7fquQHaE8&pid=Api",
        code = "HW5006",
        category = Category("Hiperautos")
    ),
    ItemCar(
        name = "Aston Martin DB11",
        description = "El epítome de la elegancia británica y el rendimiento.",
        image = "https://tse4.mm.bing.net/th?id=OIP.C-HYkQ30mW5kfDuDC7vW0QHaE8&pid=Api",
        code = "HW5007",
        category = Category("Gran Turismo")
    ),
    ItemCar(
        name = "Rolls-Royce Phantom",
        description = "Lujo supremo combinado con un diseño impresionante.",
        image = "https://tse1.mm.bing.net/th?id=OIP.t0K7ljQEB8PUpwUMVJw_kwHaEv&pid=Api",
        code = "HW5008",
        category = Category("Sedanes de lujo")
    ),
    ItemCar(
        name = "Chevrolet Corvette C8",
        description = "El primer Corvette con motor central, redefiniendo la marca.",
        image = "https://tse2.mm.bing.net/th?id=OIP.UAHLP0mQioSePx3o3EbnUgHaEK&pid=Api",
        code = "HW5009",
        category = Category("Superdeportivos")
    ),
    ItemCar(
        name = "Pagani Huayra",
        description = "Un hiperdeportivo artesanal con detalles únicos.",
        image = "https://tse2.mm.bing.net/th?id=OIP.ZFUmAtaICSeLWcYWrIXL4wHaEK&pid=Api",
        code = "HW5010",
        category = Category("Hiperautos")
    )
)
