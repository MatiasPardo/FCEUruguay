# Facturacion electronica URUGUAY - ```Proveedor FACTURU```

## Starting 馃殌

Tools for sending electronic remittances in ARBA

# Ambientes

## Testing

Web Interface: http://test.facturu.com
REST API Base URL: http://api.test.facturu.com

## Producci贸n

Web Interface: https://sistema.facturu.com
REST API Base URL: https://api.facturu.com

### Descripci贸n REST API
Todos los servicios ofrecidos por la REST API validan las credenciales del cliente para su
correcta autenticaci贸n y autorizaci贸n.
Las credenciales del cliente est谩n compuestas por una API_KEY y una API_SECRET, las
mismas deben ser enviadas como valor del HTTP Header Authorization con el siguiente
formato:
```
API_KEY/API_SECRET
```

### Deploy 馃敡
```
Download the jar and associate it to your java project
```

### Struct - Data Type 

#Type voucher:
```
101: eTicket
102: NC de eTicket
103: ND de eTicket
111: eFactura
112: NC de eFactura
113: ND de eFactura
121: eFactura de Exportaci贸n
122: NC de eFactura de Exportaci贸n
123: ND de eFactura de Exportaci贸n
```

#Doc type:
```
2: RUC (Uruguay)
3: C.I. (Uruguay)
4: Otros
5: Pasaporte (all the countries)
6: DNI (identity document from Argentina, Brazil, Chile or Paraguay)
```

#Sale Clouse:
```
 FOB, CIF, etc鈥? (if it does not apply, it goes N/A, which is the default value)
```

#Sale mode:
```
1: R茅gimen General (default)
2: Consignaci贸n
3: Precio Revisable
4: Bienes propios a exclaves aduaneros
90: R茅gimen general exportaci贸n de servicios
99: Otras transacciones
```

#Transportation Route:
```
1: Mar铆timo
2: A茅reo
3: Terrestre
8: N/A (default)
9: Otro
```

#Billing Indicator:
```
1: Exento de IVA
2: Gravado a Tasa M铆nima
3: Gravado a Tasa B谩sica
4: Gravado a 鈥淥tra Tasa鈥?
6: Producto o servicio no facturable
7: Producto o servicio no facturable negativo
10: Exportaci贸n y asimiladas
```

#Print Style:
```
OneCopy: Hoja entera A4
OneCopyHalfSheet: Media hoja A4
TwoSeparatedCopies: Dos hojas enteras A4
TwoJoinedCopies: Dos v铆as media hoja A4 (en la misma p谩gina)
TwoJoinedCopiesVertical: Dos v铆as media hoja vertical A4 (en la misma p谩gina)
VerticalInfinite80MM: Ticketera 80 mil铆metros
VerticalInfinite50MM: Ticketera 50 mil铆metros
```

## Autors 鉁掞笍

* **Matias Pardo** - [MatiasPardo](https://github.com/matiaspardo)

