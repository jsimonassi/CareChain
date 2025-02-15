import React from 'react';
import {Text, TextInput, View, StyleSheet} from 'react-native';
import {InputContainer, InputText, TextView} from './styles';

interface InputProps {
  name: string;
}

export const Input = ({name}: InputProps) => {
  const [number, onChangeNumber] = React.useState('');
  return (
    <InputContainer>
      <TextView>
        <InputText>{name}</InputText>
      </TextView>
      <TextInput
        style={stylesInput.input}
        onChangeText={onChangeNumber}
        value={number}
        // placeholder="useless placeholder"
        keyboardType="numeric"
      />
    </InputContainer>
  );
};

const stylesInput = StyleSheet.create({
  input: {
    height: 35,
    width: 71,
    margin: 12,
    borderRadius: 8,
    backgroundColor: '#FFF',
    textAlign: 'center',
    color: '#000',
  },
});
