import 'dart:ffi';
import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter/painting.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/widgets.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  // This widget is the root of your application.
  double weight = 0;
  double height = 0;
  double imc = -1;

  AssetImage getImageByImc(double imc){
    if (imc < 18.5) {
      return const AssetImage('imgs/abaixo.png');
    } else if (imc < 25) {
      return const AssetImage('imgs/normal.png');
    } else if (imc < 30) {
      return const AssetImage('imgs/sobrepeso.png');
    } else if (imc < 35) {
      return const AssetImage('imgs/obesidadeI.png');
    } else if (imc < 40) {
      return const AssetImage('imgs/obesidadeII.png');
    } else if (!imc.isNaN) {
      return const AssetImage('imgs/obesidadeIII.png');
    } else {
      return const AssetImage('imgs/invalid.png');
    }
  }

  String getMessageByImc(double imc){
    if(imc == double.nan || imc == double.infinity || imc.isNaN){
      return 'Medidas inválidas';
    }

    if(imc == -1){
      return 'Informe as medidas';
    }

    if (imc < 18.5) {
      return 'Abaixo do Peso';
    } else if (imc < 25 && imc >= 18.5) {
      return 'Peso Normal';
    } else if (imc < 30 && imc >= 25) {
      return 'Sobrepeso';
    } else if (imc < 35 && imc >= 30) {
      return 'Obesidade Grau I';
    } else if (imc < 40 && imc >= 35) {
      return 'Obesidade Grau II';
    } else {
      return 'Obesidade Mórbida';
    }
  }

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
        title: 'Calculadora App',
        home: Scaffold(
          appBar: AppBar(
            backgroundColor: Colors.purple,
            title: Center(
                child: Text(
              'Calculadora de IMC',
              style: TextStyle(color: Colors.white),
            )),
          ),
          body: Container(
              padding: EdgeInsets.all(10),
              child: ListView(children: [
                TextFormField(
                  keyboardType: TextInputType.numberWithOptions(
                    decimal: true,
                    signed: false,
                  ),
                  decoration: InputDecoration(hintText: 'Peso (KG)'),
                  onChanged: (value) {
                    setState(() {
                      weight = double.tryParse(value) ?? 0;
                    });
                  },
                ),
                TextFormField(
                  keyboardType: TextInputType.numberWithOptions(
                    decimal: true,
                    signed: false,
                  ),
                  decoration: InputDecoration(hintText: 'Altura (m)'),
                  onChanged: (value) {
                    setState(() {
                      height = double.tryParse(value) ?? 0;
                    });
                  },
                ),
                ElevatedButton(
                    onPressed: () {
                      setState(() {
                        imc = weight / pow(height, 2);
                      });
                    },
                    child: Text('Calcular IMC')),
                Container(
                  margin: EdgeInsets.only(top: 20),
                  child: Center(child: Text(getMessageByImc(imc))),
                ),
                Image(image: getImageByImc(imc), width: 250, height: 250,),
              ])),
        ));
  }
}
