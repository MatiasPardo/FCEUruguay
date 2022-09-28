# Facturacion electronica URUGUAY - ```Proveedor FACTURU```

## Starting 🚀

Tools for sending electronic remittances in ARBA

# Ambientes

## Testing

Web Interface: http://test.facturu.com
REST API Base URL: http://api.test.facturu.com

## Producción

Web Interface: https://sistema.facturu.com
REST API Base URL: https://api.facturu.com

### Descripción REST API
Todos los servicios ofrecidos por la REST API validan las credenciales del cliente para su
correcta autenticación y autorización.
Las credenciales del cliente están compuestas por una API_KEY y una API_SECRET, las
mismas deben ser enviadas como valor del HTTP Header Authorization con el siguiente
formato:
```
API_KEY/API_SECRET
```

### Deploy 🔧
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
121: eFactura de Exportación
122: NC de eFactura de Exportación
123: ND de eFactura de Exportación
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
 FOB, CIF, etc… (if it does not apply, it goes N/A, which is the default value)
```

#Sale mode:
```
1: Régimen General (default)
2: Consignación
3: Precio Revisable
4: Bienes propios a exclaves aduaneros
90: Régimen general exportación de servicios
99: Otras transacciones
```

#Transportation Route:
```
1: Marítimo
2: Aéreo
3: Terrestre
8: N/A (default)
9: Otro
```

#Billing Indicator:
```
1: Exento de IVA
2: Gravado a Tasa Mínima
3: Gravado a Tasa Básica
4: Gravado a “Otra Tasa”
6: Producto o servicio no facturable
7: Producto o servicio no facturable negativo
10: Exportación y asimiladas
```

#Print Style:
```
OneCopy: Hoja entera A4
OneCopyHalfSheet: Media hoja A4
TwoSeparatedCopies: Dos hojas enteras A4
TwoJoinedCopies: Dos vías media hoja A4 (en la misma página)
TwoJoinedCopiesVertical: Dos vías media hoja vertical A4 (en la misma página)
VerticalInfinite80MM: Ticketera 80 milímetros
VerticalInfinite50MM: Ticketera 50 milímetros
```

## Autors ✒️

* **Matias Pardo** - [MatiasPardo](https://github.com/matiaspardo)

