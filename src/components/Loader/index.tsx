import React from 'react';
import {ActivityIndicator} from 'react-native';
import {StyledContainer} from './styles';
import {useTheme} from 'styled-components/native';

export const Loader = () => {
  const theme = useTheme();

  return (
    <StyledContainer>
      <ActivityIndicator size="large" color={theme.palette.secondaryColor} />
    </StyledContainer>
  );
};
