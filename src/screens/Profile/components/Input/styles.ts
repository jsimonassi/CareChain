import styled from 'styled-components/native';

export const InputContainer = styled.View`
  background-color: ${({theme}) => theme.palette.secondaryColor};
  width: 342px;
  height: 44px;
  border-radius: 8px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
`;

export const TextView = styled.View`
  margin-left: 5%;
`;

export const InputText = styled.Text`
  color: ${({theme}) => theme.palette.black};
  font-size: 16px;
`;
